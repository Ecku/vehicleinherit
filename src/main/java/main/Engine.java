package main;

import java.io.Serializable;

public class Engine implements Serializable {
        private String name;
        private int power;
        public Engine(String name, int power) {
            this.name = name;
            this.power = power;
        }
    
        public String getName() {
            return name;
        }
    
        public int getPower() {
            return power;
        }
}
