package ab3;

//Alle Operationen ändern das Matrixobjekt selbst und geben das eigene Matrixobjekt zurück
//Dadurch kann man Aufrufe verketten, z.B.
//Matrix4 m = new Matrix4().scale(5).translate(0,1,0).rotateX(0.5f);
public class Matrix4 {
	
	//Spaltenweise 
	public float[] matrix;
	public Matrix4() {
		// TODO mit der Identitätsmatrix initialisieren
		matrix = new float[] {
				1, 0, 0, 0,
				0, 1, 0, 0,
				0, 0, 1, 0,
				0, 0, 0, 1
		};
	}

	public Matrix4(Matrix4 copy) {
		// TODO neues Objekt mit den Werten von "copy" initialisieren
		Matrix4 newMat = new Matrix4();
		newMat.matrix = copy.matrix;
	}

	public Matrix4(float n, float f, float r, float l, float b, float t) {
		// TODO erzeugt Projektionsmatrix mit Abstand zur nahen Ebene "near" und Abstand zur fernen Ebene "far", ggf. weitere Parameter hinzufügen
		matrix = new float[] {
				  2 * n / (r - l),                 0,				     0,  0,
				                0,   2 * n / (t - b),                    0,  0,
				(r + l) / (r - l), (t + b) / (t - b),   -(f + n) / (f - n), -1,
				                0,                 0, -2 * f * n / (f - n),  0
		};
	}
	
	public Matrix4(float near, float far) {
		matrix = new float[] {
				2 * near, 0, 0, 0, //or 2*near/b
				0, 2 * near, 0, 0, //or 2*near/h
				0, 0, (-far - near)/ (far - near), -1, // 3. Spalte
				0, 0, -2 * far * near /(far - near), 0
		};
	}

	public Matrix4 multiply(Matrix4 other) {
		// TODO hier Matrizenmultiplikation "this = other * this" einfügen
		Matrix4 newMat = new Matrix4();
		int pos;
		float val = 0;
		for (int y = 0; y < 4; y++) { 
			for (int x = 0; x < 4; x++) {
				pos = x * 4 + y;  //da die matrix spaltenweise ist 
				for(int k = 0; k < 4; k++) {
					//Zeile * Spalte
					val += other.matrix[4 * k + y] * matrix[k + 4 * x];
				}
				newMat.matrix[pos] = val;
				val = 0;
				
			}
		}
		this.matrix = newMat.matrix;
		return this;
	}

	public Matrix4 translate(float x, float y, float z) {
		// TODO Verschiebung um x,y,z zu this hinzufügen
		Matrix4 matTranslate = new Matrix4();
		matTranslate.matrix[12] = x;
		matTranslate.matrix[13] = y;
		matTranslate.matrix[14] = z;
		return multiply(matTranslate);
	}

	public Matrix4 scale(float uniformFactor) {
		// TODO gleichmäßige Skalierung um Faktor "uniformFactor" zu this hinzufügen
		Matrix4 mScale = new Matrix4();
		mScale.matrix[0] = mScale.matrix[5] = mScale.matrix[10] = uniformFactor;
		
		return multiply(mScale);
	}

	public Matrix4 scale(float sx, float sy, float sz) {
		// TODO ungleichförmige Skalierung zu this hinzufügen
		Matrix4 mScale = new Matrix4();
		mScale.matrix[0] = sx; 
		mScale.matrix[5] = sy;
		mScale.matrix[10] = sz;
		return multiply(mScale);
	}

	public Matrix4 rotateX(float angle) {
		// TODO Rotation um X-Achse zu this hinzufügen
		double rad = Math.toRadians(angle);
		float sin = (float) Math.sin(rad);
		float cos = (float) Math.cos(rad);
		Matrix4 mRotate = new Matrix4();
		mRotate.matrix[5] = cos; 
		mRotate.matrix[6] = sin;
		mRotate.matrix[9] = -sin;
		mRotate.matrix[10] = cos;
		return multiply(mRotate);
	}

	public Matrix4 rotateY(float angle) {
		// TODO Rotation um Y-Achse zu this hinzufügen
		double rad = Math.toRadians(angle);
		float sin = (float) Math.sin(rad);
		float cos = (float) Math.cos(rad);
		Matrix4 mRotate = new Matrix4();
		mRotate.matrix[0] = cos; 
		mRotate.matrix[2] = sin;
		mRotate.matrix[8] = -sin;
		mRotate.matrix[10] = cos;
		return multiply(mRotate);
	}

	public Matrix4 rotateZ(float angle) {
		// TODO Rotation um Z-Achse zu this hinzufügen
		double rad = Math.toRadians(angle);
		float sin = (float) Math.sin(rad);
		float cos = (float) Math.cos(rad);
		Matrix4 mRotate = new Matrix4();
		mRotate.matrix[0] = cos; 
		mRotate.matrix[1] = sin;
		mRotate.matrix[4] = -sin;
		mRotate.matrix[5] = cos;
		return multiply(mRotate);
	}

	public float[] getValuesAsArray() {
		// TODO hier Werte in einem Float-Array mit 16 Elementen (spaltenweise gefüllt) herausgeben
		return matrix;
	}
}
