package com.address.server.service;

import com.address.server.entity.IpAddress;
import com.address.server.repository.IpAddressRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class IpAddressService {

    IpAddressRep addressRep;
    private static final String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    @Autowired
    public IpAddressService(IpAddressRep addressRep) {
        this.addressRep = addressRep;
    }

    public String processing(String address) {
        String flag = "Адресс верный!";

        if (isValidInet4Address(address)) {
            if (compWithBlackList(address)) {
                flag = "Адресс в черном списке!";
            } else if (findIpAddressBase(address) == null) {
                IpAddress ip = new IpAddress(address);
                addressRep.save(ip);
            }
        }else{
            flag = "Адресс написан неверно!";
        }

        return flag;
    }

    public IpAddress findIpAddressBase(String address) {
        return addressRep.findIpAddressBase(address);
    }

    public static boolean isValidInet4Address(String ip) {
        Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);
        if (ip == null) {
            return false;
        }
        Matcher matcher = IPv4_PATTERN.matcher(ip);
        return matcher.matches();
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
