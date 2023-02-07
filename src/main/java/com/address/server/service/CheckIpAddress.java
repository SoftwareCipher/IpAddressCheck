package com.address.server.service;

import com.address.server.repository.IpAddressRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class CheckIpAddress {

    IpAddressRep ipAddressRep;
    String address;

    @Autowired
    public CheckIpAddress(IpAddressRep ipAddressRep) {
        this.ipAddressRep = ipAddressRep;
    }

    public void processing(String address){
        this.address = address;

        if(findIpAddressBase()){

        }else if(compWithBlackList()){

        }
    }

    public boolean findIpAddressBase(){
        return ipAddressRep.findIpAddressBase(address);
    }

    public boolean compWithBlackList(){
        boolean flag = false;
        try{
            File file = new File("blacklist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader buff = new BufferedReader(fr);
            String line = buff.readLine();
            while (line != null){
                if(line.equals(address)){
                    flag = true;
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return flag;
    }


}
