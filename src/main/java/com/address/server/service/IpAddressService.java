package com.address.server.service;

import com.address.server.repository.IpAddressRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class IpAddressService {

    IpAddressRep addressRep;

    @Autowired
    public IpAddressService(IpAddressRep addressRep) {
        this.addressRep = addressRep;
    }

    public String processing(String address) {
        String flag = "1111";

        if (compWithBlackList(address)) {
            flag = "Адресс в черном списке!";
        } else {
            flag = "Адресс верный!";
        }

        return flag;
    }

    public boolean findIpAddressBase(String address) {
        return addressRep.findIpAddressBase(address);
    }

    public boolean compWithBlackList(String address) {
        boolean flag = false;
        try (BufferedReader buff = new BufferedReader(new FileReader("blacklist.txt"))) {
            while (buff.readLine() != null) {
                String line = buff.readLine();
                if (line.equals(address)) {
                    flag = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
