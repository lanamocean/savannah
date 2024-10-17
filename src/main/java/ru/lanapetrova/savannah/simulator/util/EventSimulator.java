package ru.lanapetrova.savannah.simulator.util;

import ru.lanapetrova.savannah.simulator.entity.Lion;

public class EventSimulator {

    // 0-10 // 10% // лев поспал + 15 энергии
    // 10-20 // 10% // лев просто пробежал - 5 энергии
    // 20-30 // 10% // лев съел антилопу - 10 энергии; coeff * 3 здоровья
    // 30-40 // 10% // лев съел зебру - 7 энергии; coeff * 2 здоровья
    // 40-50 // 10%// на льва напал охотник - 20 здоровья
    // 50-60 // 10% // лев попил воды + 7 энергии
    // 60-70 // 10% // льва укусил тукан - 15 здоровья
    // 70-80 // 10% // лев искупался в реке + 3 энергии; coeff * 1 здоровья
    // 80-90 // 10% // лев поиграл с львятами - 2 энерги; coeff * 1 здоровья
    // 90-100 // 10% // лев съел жирафа - 6 энергии; coeff * 2 здоровья
    // энергия = 0 то - 5 здоровья


    public void startSimulation(Lion lion) {
        // 0.0 * 100 = 0
        // 0.46 * 100 = 46
        // 1.0 * 100 = 100
        int timer = 0;
        while(checkStatus(lion)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 10) {
                sleepEvent(lion);
            } else if (eventNumber >= 10 && eventNumber < 20) {
                move(lion);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                lionEatAntelope(lion);
            } else if (eventNumber >= 30 && eventNumber < 40) {
                lionEatZebra(lion);
            } else if (eventNumber >= 40 && eventNumber < 50) {
                hunterAttack(lion);
            } else if (eventNumber >= 50 && eventNumber < 60) {
                lionDrinkWater(lion);
            } else if (eventNumber >= 60 && eventNumber < 70) {
                toucanBite(lion);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                swimInTheRiver(lion);
            } else if (eventNumber >= 80 && eventNumber <90) {
                play(lion);
            } else if (eventNumber >= 90 && eventNumber <100) {
                lionEatGiraffe(lion);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timer ++;
        }
        System.out.println("К сожалению, лев умер через " + timer + " секунд!");
    }

    private void sleepEvent(Lion lion) {
       int energy = lion.getEnergy();
       energy = energy + 15;
       if (energy > 100){
           energy = 100;
       }
       lion.setEnergy(energy);
       checkEnergy(lion);
       System.out.println("Лев поспал! + 20 энергии. Текущая энергия: " + lion.getEnergy());
    }

    private void move(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев побегал, но никого не съел: - 5 энергии! Текущая энергия: " + lion.getEnergy());
    }

    private void lionEatAntelope(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (lion.getAttack() * 3);
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Лев съел антилопу! Текущая энергия: " + lion.getEnergy() + ". Текущее здоровье: " + lion.getHealth());
    }

    private void lionEatZebra(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 7;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (lion.getAttack() * 2);
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Лев съел зебру! Текущая энергия: " + lion.getEnergy() + ". Текущее здоровье: " + lion.getHealth());
    }

    private void hunterAttack(Lion lion) {
        int health = lion.getHealth();
        health = health - 20;
        if (health < 0) {
            health = 0;
        }
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("На льва напал охотник! Текущее здоровье: " + lion.getHealth());
    }

    private void lionDrinkWater(Lion lion) {
        int energy = lion.getEnergy();
        energy = energy + 7;
        if (energy > 100){
            energy = 100;
        }
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев попил воды! + 10 энергии. Текущая энергия: " + lion.getEnergy());
    }

    private void toucanBite(Lion lion) {
        int health = lion.getHealth();
        health = health - 15;
        if (health < 0) {
            health = 0;
        }
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Льва укусил тукан! Текущее здоровье: " + lion.getHealth());
    }

    private void swimInTheRiver(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy + 3;
        if (energy > 100){
            energy = 100;
        }
        health = health + (int) (lion.getAttack() * 1);
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Лев искупался в реке! Текущая энергия: " + lion.getEnergy() + ". Текущее здоровье: " + lion.getHealth());
    }

    private void play(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 2;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (lion.getAttack() * 1);
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Лев поиграл с львятами! Текущая энергия: " + lion.getEnergy() + ". Текущее здоровье: " + lion.getHealth());
    }

    private void lionEatGiraffe(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHealth();
        energy = energy - 6;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (lion.getAttack() * 2);
        if (health > 100) {
            health = 100;
        }
        lion.setEnergy(energy);
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Лев съел зебру! Текущая энергия: " + lion.getEnergy() + ". Текущее здоровье: " + lion.getHealth());
    }

    //true - продолжается симуляция
    //false - умер
    private boolean checkStatus(Lion lion) {
        System.out.println("hp: " + lion.getHealth() + " energy: " + lion.getEnergy());
        if (lion.getHealth() <= 0) {
            return false;
        } else  {
            return true;
        }
    }

    private void checkEnergy(Lion lion) {
        if(lion.getEnergy() <= 0) {
            int health = lion.getHealth();
            health = health - 5;
            if(health < 0) {
                health = 0;
            }
            lion.setHealth(health);
        }
    }
}
