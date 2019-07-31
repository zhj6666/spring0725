package com.zhj.spring0725.service;

import com.zhj.spring0725.bean.Client;

import java.util.List;

public interface ClientService {

    public List<Client> selectClient();

    public void addClient(Client client);

    public void delClient(int id);

    public void updateClient(Client client);

}
