


import java.util.ArrayList;
import java.util.Arrays;


public class Player {
    private int victoryPoints;
    private ArrayList<ResourceCard> resourceCards;
    private ArrayList<DevelopmentCard> developmentCards;
    private ArrayList<Infrastructure> infrastructureList;
    private boolean hasLongestRoad, hasLargestArmy;
    private String color;
    private int hasCity[][];
    private int number;
    private int settlements;
    private int roads;
    private int cities;

    public int settlementNumber() {
        return settlements;
    }

    public int roadNumber() {
        return roads;
    }

    public int cityNumber() {
        return cities;
    }

    public void setSettlements(int x) {
        settlements = x;
    }

    public void setCities(int x) {
        cities = x;
    }

    public void setRoads(int x) {
        roads = x;
    }

    public Player(int num, String c) {
        resourceCards = new ArrayList<>();
        developmentCards = new ArrayList<>();
        infrastructureList = new ArrayList<>();
        hasLargestArmy = false;
        hasLongestRoad = false;
        hasCity = new int[19][6];
        settlements = 5;
        cities = 4;
        roads = 15;
        for (int i = 0; i < 19; i++) {
            Arrays.fill(hasCity[i], -1);
        }
        //-1 is nothing
        //0 is settlement
        //1 is city
        setNumber(num);
        setColor(c);
    }

    public void setNumber(int num) {
        number = num;
    }

    public void setColor(String c) {
        color = c;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void addVictoryPoints(int num) {
        victoryPoints += num;
    }

    public ArrayList<ResourceCard> getResourceCards() {
        return resourceCards;
    }

    public ArrayList<DevelopmentCard> getDevelopmentCards() {
        return developmentCards;
    }

    public ArrayList<Infrastructure> getInfrastructureList() {
        return infrastructureList;
    }

    public void addDevelopmentCard(DevelopmentCard d) {
        d.setPlayerNum(number);
        developmentCards.add(d);
    }

    public int[][] getHasCity() {
        return hasCity;
    }

    public void addDevelopmentCard() {
        addDevelopmentCard(GameState.developmentCardDeck.pop());
    }

    public void addResourceCard(ResourceCard r) {
        r.setPlayerNum(number);
        resourceCards.add(r);
    }

    public void addResourceCard() {
        addResourceCard(GameState.resourceCardDeck.pop());
    }

    public boolean has(String str) {
        for (ResourceCard r : resourceCards) {
            if (r.getType().equals(str)) {
                return true;
            }

        }
        return false;
    }

    public void remove(String str) {
        for (int i = 0; i < resourceCards.size(); i++) {
            ResourceCard r = resourceCards.get(i);
            if (r.getType().equals(str)) {
                resourceCards.remove(r);
                return;
            }
        }
    }

    public boolean equals(Player p) {
        return p.getColor().equals(color);
    }

    public boolean buildInfrastructure(String type, int tile, int location) { //returns if infrastructure was built
        if (type.equals("road")) {
            Road r = new Road(); //need to add parameters
            ArrayList<ResourceCard> x = new ArrayList<ResourceCard>();
            boolean flag = true;
            if (has("wood")) {
                System.out.println("MATTHEW IS HOT");
                remove(("wood"));
                x.add(new ResourceCard("wood"));
            } else {
                System.out.println("MATTHEW IS NOT HOT");
                flag = false;
            }
            if (has("clay")) {
                remove("clay");
                x.add(new ResourceCard("clay"));
            } else {
                flag = false;
            }
            if (flag) {
                infrastructureList.add(r);
            } else {
                for (ResourceCard reAdd : x) {
                    resourceCards.add(reAdd);
                }
            }
            return flag;
        } else if (type.equals("settlement")) {
            Settlement s = new Settlement(); //need to add parameters
            s.setCity(false);
            boolean flag = true;
            ArrayList<ResourceCard> x = new ArrayList<ResourceCard>();
            if (has("clay")) {
                remove("clay");
                x.add(new ResourceCard("clay"));
            } else {
                flag = false;
            }
            if (has("ore")) {
                remove("ore");
                x.add(new ResourceCard("ore"));
            } else {
                flag = false;
            }
            if (has("wood")) {
                remove("wood");
                x.add(new ResourceCard("wood"));
            } else {
                flag = false;
            }

            if (has(("wheat"))) {
                remove(("wheat"));
                x.add(new ResourceCard("wheat"));
            } else {
                flag = false;
            }
            if (flag) {
                infrastructureList.add(s);
                addVictoryPoints(1);
            } else {
                for (ResourceCard reAdd : x) {
                    resourceCards.add(reAdd);
                }
            }

            return flag;
        } else if (type.equals("city")) {
            Settlement s = new Settlement(); //need to add parameters
            s.setCity(true);
            ArrayList<ResourceCard> x = new ArrayList<ResourceCard>();
            boolean flag = true;
            for (int i = 0; i < 3; i++) {
                if (has(("ore"))) {
                    remove(("ore"));
                    x.add(new ResourceCard("ore"));
                } else {
                    flag = false;
                }
            }
            for (int i = 0; i < 2; i++) {
                if (has(("wheat"))) {
                    remove(("wheat"));
                    x.add(new ResourceCard("wheat"));
                } else {
                    flag = false;
                }
            }
            if (flag) {
                infrastructureList.add(s);
                addVictoryPoints(2);
            } else {
                for (ResourceCard reAdd : x) {
                    resourceCards.add(reAdd);
                }
            }
            return flag;
        }
        return false;
    }

    //still need to implement randomization of development card deck
    public boolean obtainDevelopmentCard() {
        DevelopmentCard d = GameState.developmentCardDeck.peek(); //need randomization for deck
        ArrayList<ResourceCard> x = new ArrayList<>();
        boolean flag = true;
        if (has("ore")) {
           remove("ore");
            x.add(new ResourceCard("ore"));
        } else {
            flag = false;
        }
        if (has("sheep")) {
            remove("sheep");
            x.add(new ResourceCard("sheep"));
        } else {
            flag = false;
        }
        if (has("wheat")) {
            remove("wheat");
            x.add(new ResourceCard("wheat"));
        } else {
            flag = false;
        }
        if (flag) {
            addDevelopmentCard(d);
            GameState.developmentCardDeck.pop();
        } else {
            for (ResourceCard reAdd : x) {
                resourceCards.add(reAdd);
            }
        }
        return flag;
    }

    public boolean checkLongestRoad() {
        return hasLongestRoad;
    }

    public boolean checkLargestArmy() {
        return hasLargestArmy;
    }

    public boolean trade(int playerNum, ArrayList<ResourceCard> give, ArrayList<ResourceCard> receive) {
        ArrayList<ResourceCard> temp = new ArrayList<>();
        boolean flag = true;
        ArrayList<ResourceCard> temp2 = new ArrayList<>();
        boolean flag2=true;
        for (ResourceCard r : give) {
            if (has(r.getType())) {
                temp.add(r);
                remove(r.getType()); //not sure if this works or if i need to directly remove from index

            } else {
                flag = false;
                System.out.println("trade error");//print error message

            }
        }
        if(flag==false){
            for(ResourceCard r: temp){
                resourceCards.add(r);
            }
            return false;
        }
        for(ResourceCard r : receive){
            if (GameState.players.get(playerNum).has(r.getType())) {
                temp2.add(r);
                GameState.players.get(playerNum).remove(r.getType()); //not sure if this works or if i need to directly remove from index

            } else {
                flag2 = false;
                System.out.println("trade error");//print error message
            }
        }
        if(!flag2){
            for(ResourceCard r: temp2){
                GameState.players.get(playerNum).resourceCards.add(r);
            }
            return false;
        }
        for(ResourceCard r : temp){
            GameState.players.get(playerNum).resourceCards.add(r);
        }
        for(ResourceCard r: temp2){
            resourceCards.add(r);
        }


        return true;
    }


//        if(flag){
//            for(ResourceCard r : temp){
//                GameState.resourceCardDeck.add(r);
//            }
//            for(ResourceCard r : receive){
//                resourceCards.add(r);
//                GameState.resourceCardDeck.remove(r);
//            }
//        }
//        else{
//            for(ResourceCard r : temp){
//                resourceCards.add(r);
//            }
       // }



        //return flag;


    //need to implement after GameState is done
    public ResourceCard steal(int player, int resourceIndex){
        if(GameState.players.get(player).resourceCards.isEmpty()){
            return null;
        }
        ResourceCard stolen = GameState.players.get(player).getResourceCards().remove(resourceIndex);
        addResourceCard(stolen);
        return stolen;
    }

}
