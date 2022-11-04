# Project 3 Prep

**For tessellating pluses, one of the hardest parts is figuring out where to place each plus/how to easily place plus on screen in an algorithmic way.
If you did not implement tesselation, please try to come up with an algorithmic approach to place pluses on the screen. This means a strategy, pseudocode, or even actual code! 
Consider the `HexWorld` implementation provided near the end of the lab (within the lab video). Note that `HexWorld` was the lab assignment from a previous semester (in which students drew hexagons instead of pluses). 
How did your proposed implementation/algorithm differ from the given one (aside from obviously hexagons versus pluses) ? What lessons can be learned from it?**

Answer:

public static void addPlus(int s, TETile[][] world) {
int count = 0;
int half = s / 2;
while (count <= s) {
for (int x = CENTERX - s - half; x <= CENTERX + s + half; x += 1) {
for (int y = CENTERY - half; y <= CENTERY + half; y += 1) {
world[x][y] = Tileset.FLOWER;
} }
for (int x = CENTERX - half; x <= CENTERX + half; x += 1) {
for (int y = CENTERY - s - half; y <= CENTERY + s + half; y += 1) {
world[x][y] = Tileset.FLOWER;
} }
count +=1;
} }

call this in our main with inputs s and world; can change CENTERX and CENTERY so that our function takes in a center or can randomize positions as well as designs



In the hex implementation, they used recursion to draw the rows while I used for loops and some math to account for the 
5 squares of the plus by breaking it into the horizontal and vertical setups however this is doing extra work as the 
middle square is being redrawn. While this may work for pluses, for other shapes of non-90 degree angles will cause for
many for loops so the recursive implementation with the helper positions and the class Position show great accomodation 
for varios shapes and if needing to make a desired shapes of tinier versions of said shape.











**Can you think of an analogy between the process of tessellating pluses and randomly generating a world using rooms and hallways?
What is the plus and what is the tesselation on the Project 3 side?**

Answer:

by tessellating pluses we are covering our surface of nothing with manyu pluses that can appear to be four rooms with 
a shared hallway in the center or one room with hallways on each side. This relates to randomly generating a world 
using rooms and hallways as it can help with considering what is what for our pluses (is center hallway or room) and 
then also checks to see if certain areas of the world may be overlapped or not match up with other rooms and hallways 
implemented in the world. The plus helps with determining how to create various objects and geometric shapes in our world
for Project 3 and the tessellation helps with having no overlaps such that we are not creating more work for our world
to generate as well as helping with preventing any possible bugs for when players try to interact with our world.












**If you were to start working on world generation, what kind of method would you think of writing first? 
Think back to the lab and the process used to eventually get to tessellating pluses.**

Answer:

Decide the positioning by possibly creating a class. Then see what we are being asked to do, what kind of object,
of what size, where, color/deisgn, etc. See how we can develop a recursive method and pattern to create said objects.









**What distinguishes a hallway from a room? How are they similar?**

Answer:
While both a spaces that could be utilized, a hallway is the pathway to the room. While the room can be seen
as an enclosed space, regardless of possible openings into other parts of the world, it has its distinct shape
and set up. As does a hallway, however a hallway also tends to lead into other bigger parts of the world that are more
vast and open rather than enclosed like a room.
