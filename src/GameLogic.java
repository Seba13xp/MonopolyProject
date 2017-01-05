import java.util.Scanner;

/**
 * @author Sebastian Obacz on 12/28/2016.
 * @version 1.0
 */
public class GameLogic extends Board {
    Scanner input = new Scanner(System.in);

    public GameLogic(GameboardSquare[] monopolyBoard) {
        super(monopolyBoard);
    }

    //rolling doubles or rolls
    public void rolls(Player player, Dice die1, Dice die2) {
        player.rollsDie(die1, die2);
        if (die1.getDie() == die2.getDie()) {
            player.moves(player, die1.getDie() + die2.getDie());
            player.rollsDie(die1, die2);
            if (die1.getDie() == die2.getDie()) {
                player.moves(player, die1.getDie() + die2.getDie());
                player.rollsDie(die1, die2);
                if (die1.getDie() == die2.getDie()) {
                    goToJail(player);
                } else {
                    player.moves(player, die1.getDie() + die2.getDie());
                }
            } else {
                player.moves(player, die1.getDie() + die2.getDie());
            }
        } else {
            player.moves(player, die1.getDie() + die2.getDie());
        }
    }

    public void goToJail(Player player) {
        player.setMoveIndex(-1);
//      return player.getMoveIndex();
    }

    public void landed(Player player, Player otherplayer, Bank bank, GameboardSquare[] monopolyBoard) {
        //// TODO: 11/17/2016 add special case for utility squares
        switch (player.getMoveIndex()) {
            case 0:
                //go
                player.setcurrentMoney(player.getcurrentMoney() + monopolyBoard[0].getMoneyGive());
                break;
            case 2:
                //community chest
                // TODO: 11/17/2016 pick a card
                break;
            case 4:
                //income tax
                System.out.println("What do you want to do player Pay $200 enter 1 or %10 enter 2");
                int awn = input.nextInt();
                while (awn != 1 || awn != 2) {
                    System.out.println("Incorrect input. What do you want to do player Pay $200 enter 1 or %10 enter 2");
                    awn = input.nextInt();
                }
                if (awn == 1) {
                    bank.setMoney(bank.getMoney() + 200);
                    player.setcurrentMoney(player.getcurrentMoney() - 200);
                }
                if (awn == 2) {
                    int tax = incomeTax(player, monopolyBoard);
                    bank.setMoney(bank.getMoney() + tax);
                    player.setcurrentMoney(player.getcurrentMoney() - tax);
                }
                break;
            case 7:
                //chance
                // TODO: 11/17/2016 pick a card
                break;
            case 10:
                //visit jail
                break;
            case 17:
                //community chest
                // TODO: 11/17/2016 pick a card
                break;
            case 20:
                //free parking
                break;
            case 22:
                //chance
                // TODO: 11/17/2016 pick a card
                break;
            case 40:
                //go to jail
                goToJail(player);
                break;
            case 43:
                //community chest
                // TODO: 11/17/2016 pick a card
                break;
            case 46:
                ///chance
                // TODO: 11/17/2016 pick a card
                break;
            case 48:
                //luxury tax
                break;
            default:
                if (!isPropertyOwn(player, monopolyBoard)) {
                    int inputAwn = 0;
                    while (inputAwn != 1 || inputAwn != 2) {
                        System.out.println("What do you want to do 1 to buy or 2 to auction?");
                        inputAwn = input.nextInt();
                    }
                    if (inputAwn == 1) {
                        int moneyOfSell = player.getcurrentMoney() - monopolyBoard[player.getMoveIndex()].getCost();
                        bank.setMoney(moneyOfSell);
                        player.setcurrentMoney(player.getcurrentMoney() - monopolyBoard[player.getMoveIndex()].getCost());
                        monopolyBoard[player.getMoveIndex()].setPropertyOwner(player);
                    }
                    // TODO: 11/16/2016 real bad code need to look over logic
                    if (inputAwn == 2) {
                        System.out.println("How much is the starting bid player?");
                        int bidPool = playerBid(player);
                        boolean cont = false;
                        while (cont) {
                            System.out.println("Other player do you wish to bid 1 for yes or 2 for no?");
                            int awn1 = input.nextInt();
                            if (awn1 == 1) {
                                System.out.println("How much do you want to bid it must be high then previous bid");
                                int bid = playerBid(otherplayer);
                                while (bid < bidPool) {
                                    System.out.println("Bid must be high then previous bid");
                                    bid = playerBid(otherplayer);
                                }
                            }
                            // TODO: 11/17/2016 who wins the auction
                            cont = true;
                            //// TODO: 11/16/2016 add player who is selling the property to bid
                        }
                        otherplayer.setcurrentMoney(otherplayer.getcurrentMoney() - bidPool);
                        bank.setMoney(bidPool);
                    }
                } else {
                    GameboardSquare a = monopolyBoard[player.getMoveIndex()];
                    if (player != a.getPropertyOwner()) {
                        if (a.getNumberHouse() > 0 || a.getNumberHotels() > 0) {
                            Player otherPlayer = a.getPropertyOwner();
                            int numberOfHousesRent = a.getNumberHouse();
                            // TODO: 1/4/2017 see is the person has all same color propertys owned if they do increse rent
                            //// TODO: 11/16/2016 if chech if the property has house or hotels
                            switch (numberOfHousesRent) {
                                case 0:
                                    player.setcurrentMoney(player.getcurrentMoney() - a.getRent());
                                    otherPlayer.setcurrentMoney(a.getRent());
                                    break;
                                case 1:
                                    player.setcurrentMoney(player.getcurrentMoney() - a.getRent1());
                                    otherPlayer.setcurrentMoney(a.getRent1());
                                    break;
                                case 2:
                                    player.setcurrentMoney(player.getcurrentMoney() - a.getRent2());
                                    otherPlayer.setcurrentMoney(a.getRent2());
                                    break;
                                case 3:
                                    player.setcurrentMoney(player.getcurrentMoney() - a.getRent3());
                                    otherPlayer.setcurrentMoney(a.getRent3());
                                    break;
                                case 4:
                                    player.setcurrentMoney(player.getcurrentMoney() - a.getRent4());
                                    otherPlayer.setcurrentMoney(a.getRent4());
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                break;
        }
        //// TODO: 11/17/2016 add method if the player wats to build a house or a hotel on his turn
        System.out.println("What do you want to do on your turn?");
        System.out.println("1 to build a house on a property you own.");
        System.out.println("2 to build a hotel on a property you own.");
        System.out.println("3 don't what to do anything so end my turn.");
        int awn = input.nextInt();
        while (awn != 1 || awn != 2 || awn != 3) {
            System.out.println("Wrong input try again");
            System.out.println("1 to build a house on a property you own.");
            System.out.println("2 to build a house on a property you own.");
            System.out.println("3 don't what to do anything so end my turn.");
            awn = input.nextInt();
        }
        while (awn == 1 || awn == 2 && awn != 3) {
            if (awn == 1) {
                int propertyIndex;
                System.out.println("Which property would you like to buy a house on");
                propertyIndex = input.nextInt();
                buyHouse(player, propertyIndex);
                System.out.println("Do you to buy more house on a different property");
                System.out.println("1 for yes");
                System.out.println("2 for no");
                int responces = input.nextInt();
                while (responces != 1 || responces != 2) {
                    System.out.println("Wrong input");
                    System.out.println("Do you to buy more house on a different property");
                    System.out.println("1 for yes");
                    System.out.println("2 for no");
                    responces = input.nextInt();
                }
                if (responces == 2) {
                    awn = 3;
                }
            }
            if (awn == 2) {
                int propertyIndex;
                System.out.println("Which property would you like to buy a house on");
                propertyIndex = input.nextInt();
                // TODO: 12/17/2016 hotel buy method like house buy method
                System.out.println("Do you to buy more house on a different property");
                System.out.println("1 for yes");
                System.out.println("2 for no");
                int responces = input.nextInt();
                while (responces != 1 || responces != 2) {
                    System.out.println("Wrong input");
                    System.out.println("Do you to buy more house on a different property");
                    System.out.println("1 for yes");
                    System.out.println("2 for no");
                    responces = input.nextInt();
                }
                if (responces == 2) {
                    awn = 3;
                }
            }
        }
    }

    public boolean isPropertyOwn(Player player, GameboardSquare[] monopolyBoard) {
        return monopolyBoard[player.getMoveIndex()].getPropertyOwner() != null;
    }

    public int incomeTax(Player player, GameboardSquare[] monopolyBoard) {
        int total = 0;
        total += player.getcurrentMoney();
        for (int i = 1; i < monopolyBoard.length; i++) {
            GameboardSquare a = monopolyBoard[i];
            if (a.getPropertyOwner() == player) {
                if (a.isHasMortgage()) {
                    total += a.getMortgage();
                    total += a.getNumberHouse() * a.getHouseCost();
                    total += a.getNumberHotels() * a.getHouseCost();
                }
            } else {
                total += a.getCost();
                if (a.hasHouse(player, monopolyBoard)) {
                    total += a.getNumberHouse() * a.getHouseCost();
                }
                if (a.hasHotel(player, monopolyBoard)) {
                    total += a.getNumberHotels() * a.getHouseCost();
                }
            }
        }
        double tax = total - (total * .10);
        return (int) tax;
    }

    public boolean buyHouse(Player player, int propertyIndex) {
        boolean boughtHouse = false;
        GameboardSquare property = getMonopolyBoard()[propertyIndex];
        if (property.getNumberHouse() <= 3) {
            System.out.println("How many houses you want to buy? it must be between 1-4: ");
            int numHouseToBuy = input.nextInt();
            System.out.println(numHouseToBuy);
            while (numHouseToBuy > 5 && numHouseToBuy <= -1) {
                System.out.println("You can only buy 1-4");
                System.out.println("How many houses you want to buy? it must be between 1-4");
                numHouseToBuy = input.nextInt();
            }
            if (numHouseToBuy + property.getNumberHouse() <= 4 && numHouseToBuy >= 0) {
                player.setcurrentMoney(player.getcurrentMoney() - (property.getHouseCost() * numHouseToBuy));
                property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                boughtHouse = true;
            } else {
                System.out.println("To many houses on this property to buy");
                System.out.println("You can only buy " + (4 - property.getNumberHouse()));
                numHouseToBuy = input.nextInt();
                while (numHouseToBuy + property.getNumberHouse() > 4 && numHouseToBuy >= 0) {
                    System.out.println("To many houses on this property");
                    System.out.println("You can only buy " + (4 - property.getNumberHouse()));
                    numHouseToBuy = input.nextInt();
                }
                player.setcurrentMoney(player.getcurrentMoney() - (property.getHouseCost() * numHouseToBuy));
                property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                boughtHouse = true;
            }
            System.out.println("You bought: " + numHouseToBuy + " house and property: " + property.getSquareName() + " has " + property.getNumberHouse() + " houses");
            return boughtHouse;
        } else {
            System.out.println("You own 4 houses on this property already");
            return boughtHouse;
        }
    }

    public boolean buyHotel(Player player, int propertyIndex) {
        boolean boughtHotel = false;
        GameboardSquare property = getMonopolyBoard()[propertyIndex];
        if (property.getNumberHouse() == 4 && property.getNumberHotels() < 1) {
            System.out.println("Do you wish to buy a hotel 1 for yes and 2 for No? ");
            int userinput = input.nextInt();
            System.out.println(userinput);
            while ((userinput != 1) && (userinput != 2)) {
                System.out.println("Wrong input");
                System.out.println("Do you wish to buy a hotel 1 for yes and 2 for No? ");
                userinput = input.nextInt();
            }
            if (userinput == 1) {
                property.setNumberHouse(0);
                property.setNumberHotels(1);
                player.setcurrentMoney(player.getcurrentMoney() - property.getHotelCost());
                boughtHotel = true;
            } else {
                System.out.println("You didnt buy a hotel");
            }
            return boughtHotel;
        } else {
            System.out.println("You cant build a hotel on this property");
            if (property.getNumberHotels() == 1) {
                System.out.println("You all ready own a hotel on this property");
            }
            if (property.getNumberHouse() < 4) {
                System.out.println("You dont have enough house on this property");
            }
            return boughtHotel;
        }
    }

    private int playerBid(Player player) {
        System.out.println("What is your bid?");
        int bid = input.nextInt();
        return bid;
    }

    //remove think about it
    public int toManyHouseOnPropertyError() {
        int numHouseToBuy = input.nextInt();
        while (numHouseToBuy != 1 || numHouseToBuy != 2 || numHouseToBuy != 3 || numHouseToBuy != 4) {
            System.out.println("To much to buy only 1-4");
            System.out.println("How many houses you want to buy? it must be between 1-4");
            numHouseToBuy = input.nextInt();
        }
        return numHouseToBuy;
    }
}