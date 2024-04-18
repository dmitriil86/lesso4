package com.example.lesson4.config;

import com.example.lesson4.Entety.Logins;
import com.example.lesson4.Entety.Users;
import com.example.lesson4.exceptions.DataInStringIsNull;
import com.example.lesson4.repository.LoginsRepository;
import com.example.lesson4.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SaveInDataBaseImpl implements SaveInterface {

    private final UsersRepository usersRepository;
    private final LoginsRepository loginsRepository;
    private final List<CheckerInterface> checkerInterfaceList;

    private final ReaderWriterInterface readerWriterInterface;
    @Override
    public void saveString(Map<String, List<String>> map) {

        for(var m : map.entrySet() ) {

            for (String str : m.getValue()) {

                String[] data = str.split(" ");

                try {
                    for (CheckerInterface checkerInterface : checkerInterfaceList) {

                        data = checkerInterface.check(data);

                    }

                    Users user = new Users();
                    user.setUserName(data[0]);
                    user.setFio(data[1] + " " + data[2] + " " + data[3]);
                    user = usersRepository.save(user);

                    Logins login = new Logins();
                    login.setAccessDate(LocalDate.parse(data[4]));
                    login.setApplication(data[5]);
                    login.setUser(user);
                    loginsRepository.save(login);

                }catch (DataInStringIsNull e)
                {
                    readerWriterInterface.write(m.getKey()+" "+str+'\n');
                }
            }
        }
    }
}
