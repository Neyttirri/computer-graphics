package ab3;

import static org.lwjgl.opengl.GL30.*;

import lenz.opengl.AbstractOpenGLBase;
import lenz.opengl.ShaderProgram;

public class Aufgabe3undFolgende extends AbstractOpenGLBase {

	private ShaderProgram shaderProgram;
	
	private Matrix4 mat = new Matrix4();
	private Matrix4 perspective = new Matrix4(1, 10);
	private int degree = 30;

	public static void main(String[] args) {
		new Aufgabe3undFolgende().start("CG Aufgabe 3", 700, 700);
		
	}

	@Override
	protected void init() {
		shaderProgram = new ShaderProgram("aufgabe3");
		glUseProgram(shaderProgram.getId());
		// Koordinaten, VAO, VBO, ... hier anlegen und im Grafikspeicher ablegen
		float[] ecken = new float[] {
				
				//anfang pyramid 
				-0.2f-0.2f, -0.2f, 0, //A
		  		 0.1f-0.2f, -0.2f, 0, //B
		  		 0-0.2f, 0.2f, -0.2f, //H
		  		 
		  		 0.1f-0.2f, -0.2f, 0, //B
		  		 0.2f-0.2f, 0, -0.4f, //C
		  		 0-0.2f, 0.2f, -0.2f, //H
		  		 
		  		 0.2f-0.2f, 0, -0.4f, //C
		  		 -0.1f-0.2f, 0, -0.4f, //D
		  		 0-0.2f, 0.2f, -0.2f, //H
		  		 
		  		 -0.1f-0.2f, 0, -0.4f, //D
		  		 -0.2f-0.2f, -0.2f, 0, //A
		  		 0-0.2f, 0.2f, -0.2f, //H
		  		 
		  		 -0.2f-0.2f, -0.2f, 0, //A
		  		 -0.1f-0.2f, 0, -0.4f, //D
		  		 0.2f-0.2f, 0, -0.4f, //C	

		  		 -0.2f-0.2f, -0.2f, 0, //A
		  		 0.2f-0.2f, 0, -0.4f, //C	
		  		 0.1f-0.2f, -0.2f, 0, //B
		  		 //ende pyramid
		  		 
		  		 //anfang Sterne 
		  		 0.41f-0.2f, -0.46f, 0, //G
		  		 0.54f-0.2f, -0.3f, 0.2f, //O
		  		 0.085f-0.2f, -0.42f, 0, //B
		  		 
		  		 0.54f-0.2f, -0.76f, 0, //C
		  		 0.54f-0.2f, -0.3f, 0.2f, //O
		  		 0.41f-0.2f, -0.46f, 0, //G
		  		 
		  		0.54f-0.2f, -0.76f, 0, //C
		  		0.67f-0.2f, -0.46f, 0, //H
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		
		  		0.67f-0.2f, -0.46f, 0, //H
		  		0.995f-0.2f, -0.42f, 0, //D
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		
		  		0.995f-0.2f, -0.42f, 0, //D
		  		0.73f-0.2f, -0.23f, 0, //F
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		
		  		0.73f-0.2f, -0.23f, 0, //F
		  		0.81f-0.2f, -0.03f, 0, //I
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		
		  		0.81f-0.2f, -0.03f, 0, //I
		  		0.54f-0.2f, -0.1f, 0, //A
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		
		  		0.54f-0.2f, -0.1f, 0, //A
		  		0.27f-0.2f, -0.03f, 0, //K
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		
		  		0.35f-0.2f, -0.23f, 0, //E
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		0.27f-0.2f, -0.03f, 0, //K
		  		
		  		0.085f-0.2f, -0.42f, 0, //B
		  		0.54f-0.2f, -0.3f, 0.2f, //O
		  		0.35f-0.2f, -0.23f, 0, //E
		  		
		  		//Rueckseite
		  		0.54f-0.2f, -0.76f, 0, //C
		  		0.41f-0.2f, -0.46f, 0, //G
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		
		  		0.41f-0.2f, -0.46f, 0, //G
		  		0.085f-0.2f, -0.42f, 0, //B
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		
		  		0.085f-0.2f, -0.42f, 0, //B
		  		0.35f-0.2f, -0.23f, 0, //E
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		
		  		0.35f-0.2f, -0.23f, 0, //E
		  		0.27f-0.2f, -0.03f, 0, //K
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		0.27f-0.2f, -0.03f, 0, //K
		  		0.54f-0.2f, -0.1f, 0, //A
		  		
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		0.54f-0.2f, -0.1f, 0, //A
		  		0.81f-0.2f, -0.03f, 0, //I
		  		
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		0.81f-0.2f, -0.03f, 0, //I
		  		0.73f-0.2f, -0.23f, 0, //F
		  		
		  		0.995f-0.2f, -0.42f, 0, //D
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		0.73f-0.2f, -0.23f, 0, //F

		  		0.67f-0.2f, -0.46f, 0, //H
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		0.995f-0.2f, -0.42f, 0, //D

		  		0.54f-0.2f, -0.76f, 0, //C
		  		0.54f-0.2f, -0.3f, -0.2f, //O'
		  		0.67f-0.2f, -0.46f, 0, //H
		  		//ende Sterne
		  		
		  		
		};

		//VAO
		int vaoId = glGenVertexArrays();
		glBindVertexArray(vaoId);
		
		//VBO
		generateNewVBO(ecken, 0, 3);
		float[] colors = new float[] {
				
				//pyramid
				0.7176f, 0.5843f, 0.5843f, 0,  
				0.61569f, 0.44706f, 0.45098f, 0,
				0.8078f, 0.49019f, 0.50196f, 0,
				
				0.7176f, 0.5843f, 0.5843f, 0,
				0.61569f, 0.44706f, 0.45098f, 0,
				0.8078f, 0.49019f, 0.50196f, 0,
				
				0.7176f, 0.5843f, 0.5843f, 0,
				0.61569f, 0.44706f, 0.45098f, 0,
				0.8078f, 0.49019f, 0.50196f, 0,
				
				0.7176f, 0.5843f, 0.5843f, 0, 
				0.61569f, 0.44706f, 0.45098f, 0,
				0.8078f, 0.49019f, 0.50196f, 0,
				
				
				// pyramid boden
				0.7176f, 0.5843f, 0.5843f, 0,
				0.7176f, 0.5843f, 0.5843f, 0,
				0.7176f, 0.5843f, 0.5843f, 0,
				
				0.7176f, 0.5843f, 0.5843f, 0,
				0.7176f, 0.5843f, 0.5843f, 0,
				0.7176f, 0.5843f, 0.5843f, 0,
				
				//star 
				 0.93333f, 0.78824f, 0,0,   
				 0.68235f, 0.55294f, 0.0431f,0,  
				 0.93333f, 0.78824f, 0,0, 
				 
				 0.93333f, 0.78824f, 0,0,  
				 0.68235f, 0.55294f, 0.0431f,0,   
				 0.93333f, 0.78824f, 0,0, 
				  
				 0.93333f, 0.78824f, 0,0, 
				 0.93333f, 0.78824f, 0,0, 
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.68235f, 0.55294f, 0.0431f,0,    
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				  
				 0.93333f, 0.78824f, 0,0, 
				 0.68235f, 0.55294f, 0.0431f,0,   
				 0.93333f, 0.78824f, 0,0, 
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0, 
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				 0.68235f, 0.55294f, 0.0431f,0,  
				  
				 0.68235f, 0.55294f, 0.0431f,0, 
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				  
				 0.68235f, 0.55294f, 0.0431f,0, 
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				  
				 0.68235f, 0.55294f, 0.0431f,0, 
				 0.93333f, 0.78824f, 0,0,
				 0.93333f, 0.78824f, 0,0,
				  
				 0.93333f, 0.78824f, 0,0,   
				 0.68235f, 0.55294f, 0.0431f,0, 
				 0.93333f, 0.78824f, 0,0, 
				  
				 0.93333f, 0.78824f, 0,0, 
				 0.68235f, 0.55294f, 0.0431f,0,  
				 0.93333f, 0.78824f, 0,0, 
				  
				 0.93333f, 0.78824f, 0,0, 
				 0.68235f, 0.55294f, 0.0431f,0,  
				 0.93333f, 0.78824f, 0,0, 
				  
				 0.93333f, 0.78824f, 0,0, 
				 0.68235f, 0.55294f, 0.0431f,0,  
				 0.93333f, 0.78824f, 0,0, 
				  
				 0.93333f, 0.78824f, 0,0, 
				 0.68235f, 0.55294f, 0.0431f,0, 
				 0.93333f, 0.78824f, 0,0, 
		};
		generateNewVBO(colors, 1, 4);
		glEnable(GL_DEPTH_TEST); // z-Buffer aktivieren
		glEnable(GL_CULL_FACE); // backface culling aktivieren
		
		int loc = glGetUniformLocation(shaderProgram.getId(), "matPerspective");
		glUniformMatrix4fv(loc, false, perspective.getValuesAsArray());

	}

	@Override
	public void update() {
		// Transformation durchführen (Matrix anpassen)
		mat = new Matrix4();
		mat.rotateX(degree).translate(0,0.01f,-1.5f);  //scale(1.01f);
		degree++;
	}

	@Override
	protected void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		int loc = glGetUniformLocation(shaderProgram.getId(), "myMatrix");
		glUniformMatrix4fv(loc, false, mat.getValuesAsArray());
		glDrawArrays(GL_TRIANGLES, 0, 78);
		
		// Matrix an Shader übertragen
		// VAOs zeichnen
	}

	@Override
	public void destroy() {
	}
	
	void generateNewVBO(float[] data, int location, int valuesPerVertex) {
		glBindBuffer(GL_ARRAY_BUFFER, glGenBuffers());
		glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
		glVertexAttribPointer(location, valuesPerVertex, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(location);
	}
}
