/**
 * @author Sebastian Obacz  on 11/13/2016.
 * @version 1.0
 */
public class GameboardSquare {
    private String squareName;
    private int cost;
    private int hotel;
    private int rent;
    private int moneyGive;
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;
    private int mortgage;
    private int houseCost;
    private int hotelCost;
    private int numberHouse;
    private int numberHotels;
    private boolean hasMortgage;
    private Player propertyOwner;

    //todo add player owns var and player mortgage var
    public GameboardSquare(String squareName, int cost, int houseCost, int rent, int rent1, int rent2, int rent3,
                           int rent4, int hotel, int mortgage, int moneyGive, int numberHouse, int numberHotels, Player owner, boolean hasMortgage) {
        this.squareName = squareName;
        this.cost = cost;
        this.hotel = hotel;
        this.rent = rent;
        this.moneyGive = moneyGive;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.mortgage = mortgage;
        this.houseCost = houseCost;
        this.numberHouse = numberHouse;
        this.numberHotels = numberHotels;
        this.hasMortgage = hasMortgage;
        this.propertyOwner = owner;//// TODO: 11/15/2016 make a more specific
    }

    public boolean hasHouse(Player player, GameboardSquare[] monopolyBoard) {
        return monopolyBoard[player.getMoveIndex()].getNumberHouse() > 0;
    }

    public boolean hasHotel(Player player, GameboardSquare[] monopolyBoard) {
        return monopolyBoard[player.getMoveIndex()].getNumberHotels() > 0;
    }

    public String getSquareName() {
        return squareName;
    }

    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMoneyGive() {
        return moneyGive;
    }

    public void setMoneyGive(int moneyGive) {
        this.moneyGive = moneyGive;
    }

    public int getRent1() {
        return rent1;
    }

    public void setRent1(int rent1) {
        this.rent1 = rent1;
    }

    public int getRent2() {
        return rent2;
    }

    public void setRent2(int rent2) {
        this.rent2 = rent2;
    }

    public int getRent3() {
        return rent3;
    }

    public void setRent3(int rent3) {
        this.rent3 = rent3;
    }

    public int getRent4() {
        return rent4;
    }

    public void setRent4(int rent4) {
        this.rent4 = rent4;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getHouseCost() {
        return houseCost;
    }

    public void setHouseCost(int houseCost) {
        this.houseCost = houseCost;
    }

    public int getHotelCost() {
        return hotelCost;
    }

    public void setHotelCost(int hotelCost) {
        this.hotelCost = hotelCost;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public int getNumberHotels() {
        return numberHotels;
    }

    public void setNumberHotels(int numberHotels) {
        this.numberHotels = numberHotels;
    }

    public boolean isHasMortgage() {
        return hasMortgage;
    }

    public void setHasMortgage(boolean hasMortgage) {
        this.hasMortgage = hasMortgage;
    }

    public Player getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(Player propertyOwner) {
        this.propertyOwner = propertyOwner;
    }
}
