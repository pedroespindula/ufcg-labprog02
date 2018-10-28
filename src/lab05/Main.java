package lab05;

import easyaccept.EasyAccept;

public class Main {

    public static void main(String[] args) {
        String[] easyAccept = new String[]{"lab05.saga.SAGAFacade", "acceptancetests/use_case_1.txt",
                                                                "acceptancetests/use_case_2.txt",
                                                                "acceptancetests/use_case_3.txt",
        };
        EasyAccept.main(easyAccept);
    }

}
