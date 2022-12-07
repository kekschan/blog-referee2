package ru.dnsbo.blogreferee2.data;

import org.springframework.data.repository.CrudRepository;
import ru.dnsbo.blogreferee2.models.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users,Long> {
    @Override
    Optional<Users> findById(Long aLong);

    Optional<Users> findByEmail(String email);

    List<Users> findUsersByEmail(String email);
}
