package application;

import java.util.concurrent.TimeUnit;

public class Christmas_Tree {
    public static void main(String[] args) throws InterruptedException {

        int howManyTreeLevels = 20;

        for (int increaseLevel = 1; increaseLevel <= howManyTreeLevels; increaseLevel++) {
            consoleJump();
            for (int increaseSublevel = 1; increaseSublevel <= increaseLevel; increaseSublevel++) {
                sideMarks(Side.LEFT, "_", increaseLevel - increaseSublevel + 1);
                treeMarks(increaseSublevel);
                sideMarks(Side.RIGHT, "_", increaseLevel - increaseSublevel + 1);
            }
            treeRack(increaseLevel, "_./ \\._"); // "__/ \\__"
            treeBottom(increaseLevel, "Marry Christmas!");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void treeMarks(int maxCurrentLevel) {
        int treeMarkNumber = maxCurrentLevel * 2 - 1;
        StringBuilder treeMarksString =new StringBuilder();
        for (int count = treeMarkNumber; count > 0; count--) {
            if (treeMarkNumber == 1) {
                treeMarksString.append("X");
                continue;
            }
            if (count == maxCurrentLevel) {
                treeMarksString.append("|");
                continue;
            }
            treeMarksString.append("*");
        }
        System.out.print(treeMarksString);
    }

    private static void sideMarks(Side side, String fillWith, int maxCurrentLevel) {
        int sideMarksNumber = (maxCurrentLevel * 2 - 1) / 2;
        StringBuilder sideMarksString =new StringBuilder();
        for (int count = sideMarksNumber; count > 0; count--) {
            sideMarksString.append(fillWith);
        }
        System.out.print(sideMarksString);
        if (side == Side.RIGHT) {
            System.out.println();
        }
    }

    private static void treeRack(int maxCurrentLevel, String toFinishDrawing) {
        if ((maxCurrentLevel == 1) && (toFinishDrawing.length()/2 >= maxCurrentLevel - 1)) {
            System.out.println("|");
            return;
        }
        if ((maxCurrentLevel == 2) && (toFinishDrawing.length()/2 >= maxCurrentLevel - 1)) {
            System.out.println("\\/");
            return;
        }
        if ((maxCurrentLevel == 3) && (toFinishDrawing.length()/2 >= maxCurrentLevel - 1)) {
            System.out.println("_/ \\_");
            return;
        }
        if ((maxCurrentLevel >= 4) && (toFinishDrawing.length()/2 >= maxCurrentLevel - 1)) {
            filler(" ", maxCurrentLevel, toFinishDrawing);
            System.out.println("__/ \\__");
        } else {
            filler(" ", maxCurrentLevel, toFinishDrawing);
            System.out.println(toFinishDrawing);
        }
    }

    private static void treeBottom(int maxCurrentLevel, String toFinishDrawing) {
        System.out.println();
        filler(" ", maxCurrentLevel, toFinishDrawing);
        System.out.println(toFinishDrawing);
        System.out.println();
    }

    private static void filler(String filler, int maxCurrentLevel, String toFinishDrawing) {
        StringBuilder fillerString = new StringBuilder();
        for (int count = 0; count < ((maxCurrentLevel - 1) - toFinishDrawing.length()/2); count++) {
            fillerString.append(filler);
        }
        System.out.print(fillerString);
    }

    enum Side {
        LEFT, RIGHT
    }

    private static void consoleJump() {
        StringBuilder multiEmptyLine = new StringBuilder();
        for (int i = 0; i < 55; i++) {
            multiEmptyLine.append("\r\n");
        }
        System.out.println(multiEmptyLine.toString());
    }
}
