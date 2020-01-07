#version 330

out vec4 background;
const float PI = 3.1415926535897932384626433832795;
const float rad = float(PI / 180.0);

void rotate(inout vec2 v, float a) {
	float s = sin(a * rad);
	float c = cos(a * rad);
	mat2 m = mat2(c, s, -s, c);
	v = m * v;
}
void drawRectangle(in float length, in float height, vec2 startPointLeftBelow, vec4 colorRectangle)
{
	 vec2 coordinates = gl_FragCoord.xy;
	 rotate(coordinates, 45.0);
	 rotate(startPointLeftBelow, 45.0);
	 if((coordinates.x > startPointLeftBelow.x && coordinates.x < startPointLeftBelow.x + length) && (coordinates.y > startPointLeftBelow.y && coordinates.y < startPointLeftBelow.y + height))
	 {
		 background = colorRectangle;
	 }
}
bool isInCircle(in vec2 point, in vec2 center, in float rad)
{
	return rad >= distance(point, center);
}

void drawCircle(in vec2 center, in float radius, in vec4 colorCircle)
{
	 vec2 coordinates = gl_FragCoord.xy;
	 vec2 c = center;
	 float r = radius;
	 if(isInCircle(coordinates, c, r))
	 {
	 	background = colorCircle;
	 }
}

void drawRotatedRectangle(in float length, in float height, vec2 startPointLeftBelow, vec4 colorRectangle, float degree)
{
	 vec2 coordinates = gl_FragCoord.xy;
	 rotate(coordinates, degree);
	 rotate(startPointLeftBelow, degree);
	 if((coordinates.x > startPointLeftBelow.x && coordinates.x < startPointLeftBelow.x + length) && (coordinates.y > startPointLeftBelow.y && coordinates.y < startPointLeftBelow.y + height))
	 {
		 background = colorRectangle;
	 }
}
void main()
{
	background = vec4(0.0, 0.58, 0.58, 1.0);
//	drawRotatedRectangle(40,60, vec2(40,40), vec4(1.0, 0.0, 0.0, 1.0), 30.0);
//	drawRectangle(40,60, vec2(120,20), vec4(0.8, 0.8, 0.0, 1.0));
//	drawRectangle(100,100, vec2(360,0), vec4(0.8, 0.8, 0.0, 1.0));
//	drawRectangle(100,100, vec2(360,500), vec4(0.8, 0.8, 0.0, 1.0));
//	drawRectangle(50,50, vec2(30,500), vec4(0.8, 0.8, 0.0, 1.0));
//	drawCircle(vec2(350,350), 140.0, vec4(0.4, 0.0, 0.5, 1.0));
//	drawCircle(vec2(30,30), 40.0, vec4(0.4, 0.0, 0.5, 1.0));
//	drawCircle(vec2(550,200), 80.0, vec4(0.4, 0.0, 0.5, 1.0));
	drawRotatedRectangle(100,100, vec2(360,120), vec4(0.8, 0.8, 0.0, 1.0), 45.0);

}
