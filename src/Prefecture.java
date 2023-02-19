import java.util.Objects;

public class Prefecture implements Comparable<Prefecture> {


    private String name;
    private String region;
    private int population;

    public Prefecture(String name, String region, int population) {
        this.name = name;
        this.region = region;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "都道府県：" + name + "、" +
                "人口：" + population + "万人";
    }

    @Override
    public int compareTo(Prefecture other) {
        return Integer.compare(other.population, this.population);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prefecture that = (Prefecture) o;
        return population == that.population && Objects.equals(name, that.name) && Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, population);
    }
}
