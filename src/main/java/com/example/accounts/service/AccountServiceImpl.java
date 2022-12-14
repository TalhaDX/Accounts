package com.example.accounts.service;

import com.example.accounts.domain.Account;
import com.example.accounts.exception.DuplicateException;
import com.example.accounts.exception.NotFoundException;
import com.example.accounts.model.NotificationModel;
import com.example.accounts.repository.AccountRepository;
import com.example.accounts.service.notification.NotificationService;
import com.example.accounts.type.notification.NotificationReason;
import com.example.accounts.type.notification.NotificationSendType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public Account register(Account newAccount) throws DuplicateException {
        if(repository.findByEmail(newAccount.getEmail()) != null) throw new DuplicateException();

        Account savedAccount = repository.save(newAccount);

        notificationService.sendNotification(new NotificationModel(newAccount.getEmail(), NotificationSendType.EMAIL, NotificationReason.SIGNUP));

        return savedAccount;
    }

    @Override
    public Account update(UUID id, Account newAccount) throws NotFoundException {
        if(find(id) == null) throw new NotFoundException();

        return repository.save(newAccount);
    }

    @Override
    public Account find(UUID id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }
}
