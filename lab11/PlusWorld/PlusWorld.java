package PlusWorld;
import org.junit.Test;
import static org.junit.Assert.*;

import byowTools.TileEngine.TERenderer;
import byowTools.TileEngine.TETile;
import byowTools.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of plus shaped regions.
 */
public class PlusWorld {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final int CENTERX = WIDTH / 2;
    private static final int CENTERY = HEIGHT / 2;


    public static void addPlus(int s, TETile[][] world) {
        int count = 0;
        int half = s / 2;
        while (count <= s) {
            for (int x = CENTERX - s - half; x <= CENTERX + s + half; x += 1) {
                for (int y = CENTERY - half; y <= CENTERY + half; y += 1) {
                    world[x][y] = Tileset.FLOWER;
                }
            }
            for (int x = CENTERX - half; x <= CENTERX + half; x += 1) {
                for (int y = CENTERY - s - half; y <= CENTERY + s + half; y += 1) {
                    world[x][y] = Tileset.FLOWER;
                }
            }
            count +=1;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        addPlus(3, world);


        // draws the world to the screen
        ter.renderFrame(world);
    }


}

