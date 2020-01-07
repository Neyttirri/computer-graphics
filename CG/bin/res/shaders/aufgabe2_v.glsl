#version 330

layout(location =  0) in vec2 pos;
layout(location =  1) in vec4 color;
out vec4 colorFrag;
const float PI = 3.1415926535897932384626433832795;
const float rad = float(PI / 180.0);

void rotate(inout vec2 v, float a) {
	float s = sin(a * rad);
	float c = cos(a * rad);
	mat2 m = mat2(c, s, -s, c);
	v = m * v;
}

void main()
{
	vec2 position = pos;
	rotate(position, 30.0f);
	colorFrag = color;
	gl_Position = vec4(position, 0.0, 1.0);
}
