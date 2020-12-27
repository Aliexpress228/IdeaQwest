package com.company;

public class Story {

    private Situation start_story;
    public Situation current_situation;
    Story() {
        start_story = new Situation(
                "очнулся",
                "Вы проснулись и пытаетесь что-то понять, в животе урчит\n"
                        + "(1) Повернуться на другой бок и попытаться заснуть.\n"
                        + "(2) Встать с кровати\n",
                2, 0, 0, 0);
        start_story.dir[0] = new Situation(
                "падение",
                "Вы остались лежать.\n "
                        + "На вашу голову падает кусок потолка. Вы умерли.",
                0, 0, 0, 0);
        start_story.dir[1] = new Situation(
                "встал с кровати",
                "Встал с кровати. \n"
                        + " На вашу подушку упал массивный кусок потолка. \n Не зря встал. \n" +
                        "Что делать дальше\n" +
                        "(1) Осмотреть помещение\n" +
                        "(2) Лечь на кровать обратно\n",
                2, 0, 100, 0);
        start_story.dir[1].dir[1] = new Situation(
                "заснул",
                "Вы снова легли и заснули.\n "
                        + "Вы умерли от голода :(",
                0, -1, 0, 0);
        start_story.dir[1].dir[0] = new Situation(
                "осмотреться",
                "Вы осмотрели комнату \n"
                        + " Оказалось в квартире есть еще кухня и ванная комната  \n" +
                        "Что делать дальше\n" +
                        "(1) Пойти в ванную\n"+
                        "(2) Пойти на кухню\n" ,
                2, 0, 100, 0);
        start_story.dir[1].dir[0].dir[0] = new Situation(
                "ванная",
                "Вы осмотрели комнату \n"
                        + " Тут вода капает, вроде чистая, можно попить  \n" +
                        "Что делать дальше\n" +
                        "(1) Выйти из ванной\n" +
                        "(2) Попить водички\n",
                2, 0, 100, 0);
        start_story.dir[1].dir[0].dir[1]  = new Situation(
                "кухня",
                "Вы осмотрели кухню \n"
                        + " На столе кусок черного хлеба, на вид неплох  \n" +
                        "Что делать дальше\n" +
                        "(1) Выйти из кухни\n"+
                        "(2) Покушать его\n",
                2, 0, 100, 0);
        start_story.dir[1].dir[0].dir[0].dir[1]  = new Situation(
                "попил",
                "Вы попили этой воды \n"
                        + " Вода была холодддной, у вас заболел зуб  \n" +
                        "Вы потеряли последнюю единицу здоровья\n",
                0, 0, 100, 0);
        start_story.dir[1].dir[0].dir[1].dir[1]  = new Situation(
                "поел",
                "Хлеб оказался вкусный и полезный \n"
                        + " Вы восстановили 30 единиц здоровья  \n",
                0, 30, 100, 0);
        start_story.dir[1].dir[0].dir[1].dir[0] = new Situation(
                "посреди",
                "Теперь вы находитесь по центру этой странной квартиры \n",
                0, 0, 100, 0);
        start_story.dir[1].dir[0].dir[0].dir[0] = start_story.dir[1].dir[0].dir[1].dir[0];
        current_situation = start_story;
    }

    public void go(int num) {

        if (num <= current_situation.dir.length)
            current_situation = current_situation.dir[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.dir.length + " вариантов");
    }
    public boolean isEnd() {
        return current_situation.dir.length == 0;
    }
}