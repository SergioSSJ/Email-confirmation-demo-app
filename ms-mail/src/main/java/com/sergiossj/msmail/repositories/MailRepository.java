package com.sergiossj.msmail.repositories;

import com.sergiossj.msmail.entities.Mail;
import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail,Long>{
}
