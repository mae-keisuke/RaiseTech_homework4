import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Prefecture> prefList = new ArrayList<>();
        prefList.add(new Prefecture("大阪府", "関西", 880));
        prefList.add(new Prefecture("東京都", "関東", 1379));
        prefList.add(new Prefecture("愛知県", "東海", 753));
        prefList.add(new Prefecture("奈良県", "関西", 134));
        prefList.add(new Prefecture("京都府", "関西", 251));
        prefList.add(new Prefecture("福岡県", "九州", 511));
        prefList.add(new Prefecture("奈良県", "関西", 134));

        //「県」のみ抽出
        List<Prefecture> filteredName = prefList.stream()
                .filter(n -> n.getName().contains("県"))
                .distinct()
                .toList();

        //「県」の数をカウント
        long filteredNameNum = filteredName.stream()
                .filter(n -> n.getName().contains("県"))
                .distinct()
                .count();

        //結果出力
        System.out.println("■「県」がつく都道府県のみ抽出");
        System.out.println("数：" + filteredNameNum);
        filteredName.forEach(System.out::println);
        System.out.println("-----------------------");


        //「関西」のみ抽出
        List<Prefecture> filteredRegion = prefList.stream()
                .filter(p -> p.getRegion().equals("関西"))
                .distinct()
                .toList();

        //結果出力
        System.out.println("■ 関西のみ抽出");
        filteredRegion.forEach(System.out::println);
        System.out.println("-----------------------");


        //人口順に並び替え
        List<Prefecture> sortedPopulation = prefList.stream()
                .sorted(Comparator.comparing(Prefecture::getPopulation).reversed())
                .distinct()
                .toList();

        //結果出力
        System.out.println("■ 人口順に並び替え");
        sortedPopulation.forEach(System.out::println);
        System.out.println("-----------------------");


        //リストに「東京都」があるか調査
        boolean hasTokyo = prefList.stream()
                .anyMatch(n -> n.getName().equals("東京都"));

        //結果出力
        System.out.println("■ リストに「東京都」はある？");
        if (hasTokyo) {
            System.out.println("東京都はリストにあります");
        } else {
            System.out.println("東京都はリストにありません");
        }
        System.out.println("-----------------------");

    }
}
