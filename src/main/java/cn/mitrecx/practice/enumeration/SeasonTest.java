package cn.mitrecx.practice.enumeration;

public class SeasonTest {
    enum Season {
        SPRING("春"),
        SUMMER("夏"),
        AUTUMN("秋"),
        WINTER("冬");

        private final String desc;

        Season(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public static Season getNextSeason(Season nowSeason) {
            int nextDayValue = nowSeason.ordinal();
            if (++nextDayValue == 3) {
                nextDayValue = 0;
            }
            return getSeasonByValue(nextDayValue);
        }

        public static Season getSeasonByValue(int value) {
            for (Season s : Season.values()) {
                if (s.ordinal() == value) {
                    return s;
                }
            }
            return null;
        }
    }


    public static void main(String[] args) {
        System.out.println("1. " + Season.SPRING + "," + Season.SPRING.ordinal());
        System.out.println("2. " + Season.getNextSeason(Season.SPRING));
        System.out.println("3. " + Season.valueOf("SPRING"));
        System.out.println("4. " + Season.SUMMER.toString());
        System.out.println("5. " + Season.SUMMER.name());
        System.out.println("6. " + Season.SUMMER.getDesc());
        System.out.println("7. " + Season.SUMMER.desc);
    }
}
