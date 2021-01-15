package com.kai.demo01;

public class Proxy implements Rent{

    private Host host;


    public Proxy() {
        host=new Host();
    }

    @Override
    public void rent() {
        host.rent();
        seeHouse();
        fee();
        contract();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void fee(){
        System.out.println("收中介费");
    }

    public void contract(){
        System.out.println("签合同");
    }
}
