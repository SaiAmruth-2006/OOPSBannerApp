public class OOPSBannerApp {

    // Inner static class
    static class CharacterPatternMap {
        private char character;
        private String[] pattern;

        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    // Create pattern objects
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        String[] oPattern = {
            " *** ",
            "*   *",
            "*   *",
            "*   *",
            "*   *",
            "*   *",
            " *** "
        };

        String[] pPattern = {
            "**** ",
            "*   *",
            "*   *",
            "**** ",
            "*    ",
            "*    ",
            "*    "
        };

        String[] sPattern = {
            " ****",
            "*    ",
            "*    ",
            " *** ",
            "    *",
            "    *",
            "**** "
        };

        String[] spacePattern = {
            "     ",
            "     ",
            "     ",
            "     ",
            "     ",
            "     ",
            "     "
        };

        CharacterPatternMap[] maps = {
            new CharacterPatternMap('O', oPattern),
            new CharacterPatternMap('P', pPattern),
            new CharacterPatternMap('S', sPattern),
            new CharacterPatternMap(' ', spacePattern)
        };

        return maps;
    }

    // Find pattern for character
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {
        for (CharacterPatternMap map : maps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return maps[3].getPattern(); // space pattern
    }

    // Print banner message
    public static void printMessage(String message, CharacterPatternMap[] maps) {

        int height = 7;

        for (int i = 0; i < height; i++) {

            StringBuilder line = new StringBuilder();

            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, maps);
                line.append(pattern[i]).append("  ");
            }

            System.out.println(line);
        }
    }

    // Main method
    public static void main(String[] args) {

        CharacterPatternMap[] maps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, maps);
    }
}