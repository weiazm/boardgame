/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: Person.java
 * @Prject: BoardGame
 * @Package: com.gzdgm.xmt.entity
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年11月27日 上午9:51:39
 * @version: V1.0
 */
package com.symon.sun.boardgame.entity;

/**
 * @ClassName: Person
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年11月27日 上午9:51:39
 */
public class Person {

    private long id;

    private String name;

    private String wolf_score;

    private String god_score;

    private String villager_score;

    private String total_score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWolf_score() {
        return wolf_score;
    }

    public void setWolf_score(String wolf_score) {
        this.wolf_score = wolf_score;
    }

    public String getGod_score() {
        return god_score;
    }

    public void setGod_score(String god_score) {
        this.god_score = god_score;
    }

    public String getVillager_score() {
        return villager_score;
    }

    public void setVillager_score(String villager_score) {
        this.villager_score = villager_score;
    }

    public String getTotal_score() {
        return total_score;
    }

    public void setTotal_score(String total_score) {
        this.total_score = total_score;
    }

}
