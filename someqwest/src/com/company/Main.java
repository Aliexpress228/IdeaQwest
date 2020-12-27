package com.company;

import java.util.Scanner;

public class Main {

    public static Character human;
    public static Story story;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Вы очнулись. Где я. Ничего не помню...?! И вообще кто я? (Введите имя)");
        human = new Character(in.next());
        story = new Story();
        while (true) {
            human.H += story.current_situation.dH;
            human.R += story.current_situation.dR;
            human.I += story.current_situation.dI;
            System.out.println("=====\nЗдоровье: " + human.H + "\tРепутация: "
                    + human.R + "\tИнтеллект: " + human.I + " IQ" + "\n=====");
            System.out.println("============="
                    + story.current_situation.subject + "==============");
            System.out.println(story.current_situation.text);
            if (story.isEnd() || human.H < 1) {
                System.out.println("====================the end!===================");
                return;
            }
            story.go(in.nextInt());
        }
    }
}
