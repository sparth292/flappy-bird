//what a pipe needs ?
/* 
x
y
width
height
speed

and I want it like 

PIPE
PIPE

GAP

PIPE
PIPE
*/

package com.parth.flappybird;

public class Pipe {
    int x;
    int y;
    int width;
    int height;

    public Pipe(int x , int y , int height , int width){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
}