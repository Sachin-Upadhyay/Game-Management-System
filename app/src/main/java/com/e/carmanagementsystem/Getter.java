package com.e.carmanagementsystem;

public class Getter {

    //initialization of all fields
    String gamename, PlayerRequired, Equipments, TeamA, TeamB, rules, description;

    // constuctor which Initially gets the data
    public Getter(String gamename, String playerRequired, String equipments, String teamA, String teamB, String rules, String description) {
        this.gamename = gamename;
        PlayerRequired = playerRequired;
        Equipments = equipments;
        TeamA = teamA;
        TeamB = teamB;
        this.rules = rules;
        this.description = description;
    }

    //getting and setting the data

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public String getPlayerRequired() {
        return PlayerRequired;
    }

    public void setPlayerRequired(String playerRequired) {
        PlayerRequired = playerRequired;
    }

    public String getEquipments() {
        return Equipments;
    }

    public void setEquipments(String equipments) {
        Equipments = equipments;
    }

    public String getTeamA() {
        return TeamA;
    }

    public void setTeamA(String teamA) {
        TeamA = teamA;
    }

    public String getTeamB() {
        return TeamB;
    }

    public void setTeamB(String teamB) {
        TeamB = teamB;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

