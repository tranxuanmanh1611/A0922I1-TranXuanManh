import input.ATM;
import input.Card;
import input.CreditCard;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    ArrayList<Card> cardList = new ArrayList<>();
    ATM newATM;
    CreditCard newCreditCard;
    Scanner sc = new Scanner(System.in);

    public void register() {


        int choice;
        System.out.println("Bạn muốn tạo:\n" + "1.ATM\n" + "2.CreditCard\n");
        choice = sc.nextInt();
        sc.nextLine();
        String cardNumber = null;
        boolean isDuplicated = false;
        do {
            System.out.println("Nhập số thẻ:");
            cardNumber = sc.nextLine();

            for (Card card : cardList) {
                if (card.getCardNumber().equals(cardNumber)) {
                    isDuplicated = true;
                }
            }
            if (!Validate.validateCardNumber(cardNumber)) {
                System.out.println("Số thẻ phải đủ 12 số");
            }
            if (isDuplicated) {
                System.out.println("Số thẻ trùng");
            }
        } while (!Validate.validateCardNumber(cardNumber) || isDuplicated);
        System.out.println("Nhập tên chủ thẻ:");
        String cardOwner = sc.nextLine();
        String ownerCitizenID = null;
        do {
            System.out.println("Nhập CCCD:");
            ownerCitizenID = sc.nextLine();
            if (!Validate.validateCitizenId(ownerCitizenID)) {
                System.out.println("Định dạng CCCD phải đủ 12 số");
            }
        } while (!Validate.validateCitizenId(ownerCitizenID));
        System.out.println("Nhập địa chỉ chủ thẻ:");
        String ownerAddress = sc.nextLine();
        if (choice == 1) {
            newATM = new ATM(cardNumber, cardOwner, ownerCitizenID, ownerAddress, 0, "ATM");
            cardList.add(newATM);
            System.out.println("Tạo ATM thành công");
        } else if (choice == 2) {
            System.out.println("Nhập hạn mức tín dụng");
            int limit = sc.nextInt();
            newCreditCard = new CreditCard(cardNumber, cardOwner, ownerCitizenID, ownerAddress, 0, limit, "CreditCard");
            cardList.add(newCreditCard);
            System.out.println("Tạo thẻ tín dụng thành công");
        }
    }

    public void exportData() {
        String path = "D:\\codegym\\codegym\\module2\\atm\\atm\\data\\card.txt";
        try {
            File file = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            for (Card card : cardList) {
                if (card.getType().equals("ATM")) {
                    bufferedWriter.write(((ATM) card).toFileString());
                    bufferedWriter.write("\n");
                } else {
                    bufferedWriter.write(((CreditCard) card).toFileString());
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.close();
            System.out.println("Xuất file thành công");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void transaction() {
        Card data = find();
        if (data == null) {
            System.out.println("Không tìm thấy");
        } else {
            int choice;
            do {
                System.out.println("4.1. Thanh toán\n 4.2. Nộp tiên\n 4.3. Chuyển tiền\n 4.4. Quay lại\n");
                choice = sc.nextInt();
                if (choice == 1) {
                    payment(data);
                } else if (choice == 2) {
                    deposit(data);
                }else if (choice==3){
                    transfer(data);
                }
            } while (choice != 4);
        }
    }

    public void payment(Card input) {
        System.out.println("Chủ thẻ: " + input.getCardOwner());
        System.out.println("Nhập số tiền thanh toán: ");
        int money = sc.nextInt();
        if (input.getType().equals("ATM")) {
            if (money > input.getBalance()) {
                System.out.println("Số dư không đủ");
            } else {
                input.withdraw(money);
                System.out.println("Đã thanh toán, số dư: " + input.getBalance());

            }
        } else if (input.getType().equals("CreditCard")) {
            if (input.getBalance() + ((CreditCard) input).getLimit() - money >= 0) {
                input.withdraw(money);
                System.out.println("Thanh toán thành công, hạn mức còn: " + (input.getBalance() + ((CreditCard) input).getLimit()) + "số dư: " + input.getBalance());
            } else {
                System.out.println("Hạn mức không đủ, vui lòng thanh toan nợ");
            }
        }
    }

    public void deposit(Card input) {
                System.out.println("Nhập số tiền nạp: ");
                int money = sc.nextInt();
                input.deposit(money);
                System.out.println("Nạp tiền thành công, số dư: " + input.getBalance());
    }
    public void transfer(Card card){

        if (card.getType().equals("CreditCard")){
            System.out.println("Thẻ tín dụng không được chuyển khoản");
        }else {
            System.out.println("Nhập số tiền cần chuyen");
            int money = sc.nextInt();
            if (card.getBalance()<money){
                System.out.println("TK không đủ tiền");
            }else {
                System.out.println("Nhập tài khoản bạn muốn chuyển đến");
                Card receiveCard = find();
                card.withdraw(money);
                receiveCard.deposit(money);
                System.out.println("Đã chuyển thành công, số dư: "+card.getBalance());
            }
        }
    }


    public void importData() {
        String path = "D:\\codegym\\codegym\\module2\\atm\\atm\\data\\card.txt";
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] entry = line.split(",");
                if (entry[0].equals("ATM")) {
                    cardList.add(new ATM(entry[1], entry[2], entry[3], entry[4], Integer.parseInt(entry[5]), entry[0]));
                } else {
                    cardList.add(new CreditCard(entry[1], entry[2], entry[3], entry[4], Integer.parseInt(entry[5]), Integer.parseInt(entry[6]), entry[0]));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        display();
    }

    public Card find() {
        System.out.println("Nhap tên hoac CCCD");
        String data = sc.nextLine();
        if (!Validate.validateFind(data)) {
            System.out.println("Định dạng thẻ phải 12 số, hoặc họ tên không đúng định dạng");
            System.out.println("Nhap lại tên hoac CCCD");
            data = sc.nextLine();
        }
        Card output = null;
        boolean isFound = false;
        for (Card card : cardList) {
            if (card.getCardNumber().equals(data) || card.getCardOwner().equals(data)) {
                System.out.println("Đã tìm thấy");
                isFound = true;
                output = card;
            }
        }
        return output;
    }

    public void delete() {

    }

    public void display() {
        for (Card card : cardList) {
            if (card.getType().equals("ATM")) {
                System.out.println(((ATM) card).toString());
            } else {
                System.out.println(((CreditCard) card).toString());
            }
        }
    }
}
