#version 330

out vec4 background;
in vec4 colorFrag;
void main()
{
	background = colorFrag;
}
