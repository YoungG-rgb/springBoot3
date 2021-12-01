package com.crudonspringboot.config;

import com.crudonspringboot.models.Publication;
import com.crudonspringboot.models.Role;
import com.crudonspringboot.models.User;
import com.crudonspringboot.service.Service.PublicationService;
import com.crudonspringboot.service.Service.RoleService;
import com.crudonspringboot.service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InsertTestData {

    private final UserService userService;
    private final RoleService roleService;
    private final PublicationService publicationService;

    @PostConstruct
    public void init() throws IOException {
        //-------------------------------------------------------------------------------------------------
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Role roleStudent = new Role("ROLE_STUDENT");

        roleService.save(roleStudent);
        roleService.save(roleAdmin);
        roleService.save(roleUser);
        //-------------------------------------------------------------------------------------------------
        User admin = User.builder()
                .name("Zhalal")
                .lastName("Toichubaev")
                .nickname("Zhalaldin")
                .password("admin")
                .birthDate("12.09.2001")
                .country("Kyrgyzstan")
                .mail("tzhalal@mail.ru")
                .details("about me")
                .roles(Set.of(roleUser, roleAdmin))
                .build();

        User student = User.builder()
                .name("Erulan")
                .lastName("Sharsheev")
                .nickname("Erulan")
                .password("student")
                .birthDate("21.11.2001")
                .country("Kyrgyzstan")
                .mail("era@mail.ru")
                .details("about info")
                .roles(Set.of(roleStudent, roleUser))
                .build();

        User user1 = User.builder()
                .name("Ratbek")
                .lastName("Savitbekov")
                .nickname("Ratbek")
                .password("user")
                .birthDate("02.11.2001")
                .country("Kyrgyzstan")
                .mail("ratbek@mail.ru")
                .details("about info")
                .roles(Set.of(roleUser))
                .build();

        User user2 = User.builder()
                .name("Kabyl-ulan")
                .lastName("Uulu")
                .nickname("Ulan")
                .password("user")
                .birthDate("20.11.2001")
                .country("Kyrgyzstan")
                .mail("ulan@mail.ru")
                .details("about info")
                .roles(Set.of(roleUser))
                .build();

        userService.add(admin);
        userService.add(student);
        userService.add(user1);
        userService.add(user2);
        //-------------------------------------------------------------------------------------------------
        File publication1File = new File("C:\\Users\\Zhalaldin\\Desktop\\texts\\publication1.txt");
        File publicationImage1 = new File("C:\\Users\\Zhalaldin\\Desktop\\texts\\images\\publicationImage1.jpg");

        File publication2File = new File("C:\\Users\\Zhalaldin\\Desktop\\texts\\publication2.txt");
        File publicationImage2 = new File("C:\\Users\\Zhalaldin\\Desktop\\texts\\images\\publicationImage2.png");

        File publication3File = new File("C:\\Users\\Zhalaldin\\Desktop\\texts\\publication3.txt");
        File publicationImage3 = new File("C:\\Users\\Zhalaldin\\Desktop\\texts\\images\\publicationImage3.png");

        byte[] array_publicationText1 = Files.readAllBytes(publication1File.toPath());
        byte[] array_publicationImage1 = Files.readAllBytes(publicationImage1.toPath());

        byte[] array_publicationText2 = Files.readAllBytes(publication2File.toPath());
        byte[] array_publicationImage2 = Files.readAllBytes(publicationImage2.toPath());

        byte[] array_publicationText3 = Files.readAllBytes(publication3File.toPath());
        byte[] array_publicationImage3 = Files.readAllBytes(publicationImage3.toPath());

        Publication publication1 = Publication.builder()
                .author(admin)
                .publicationText(array_publicationText1)
                .header("Кто из программистов зарабатывает больше всех в России и почему")
                .date("19.11.2021")
                .publicationImage(array_publicationImage1)
                .theme("Карьера")
                .build();

        Publication publication2 = Publication.builder()
                .author(student)
                .publicationText(array_publicationText2)
                .header("20 советов для будущих программистов, которые ищут свою первую работу в IT")
                .date("18.11.2021")
                .publicationImage(array_publicationImage2)
                .theme("Развитие")
                .build();

        Publication publication3 = Publication.builder()
                .author(user1)
                .publicationText(array_publicationText3)
                .header("Почему представление о полиморфизме в ООП неверно")
                .date("18.11.2021")
                .publicationImage(array_publicationImage3)
                .theme("Обучение")
                .build();

        publicationService.add(publication1);
        publicationService.add(publication2);
        publicationService.add(publication3);
        //-------------------------------------------------------------------------------------------------

    }
}