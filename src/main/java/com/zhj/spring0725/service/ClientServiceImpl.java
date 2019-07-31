package com.zhj.spring0725.service;

import com.zhj.spring0725.bean.Client;
import com.zhj.spring0725.dao.ClientDao;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientDao clientDao;



    @Override
    public List<Client> selectClient() {
        return clientDao.selectClient();
    }

    @Override
    public void addClient(Client client) {
         clientDao.addClient(client);
    }

    @Override
    public void delClient(int id) {
         clientDao.delClient(id);
    }

    @Override
    public void updateClient(Client client) {
         clientDao.updateClient(client);
    }
}
