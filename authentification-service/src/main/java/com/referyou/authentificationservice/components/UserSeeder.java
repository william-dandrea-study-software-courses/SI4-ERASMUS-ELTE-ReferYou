package com.referyou.authentificationservice.components;

import org.springframework.boot.CommandLineRunner;

/**
 * @author D'Andréa William
 */
public class UserSeeder implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        this.loadUserData();
    }


    private void loadUserData() {

    }
}
