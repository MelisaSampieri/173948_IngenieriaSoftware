import static org.junit.Assert.*;
import org.junit.Test;

public class BeverageInputValidatorTest
{
    @Test
    public void testNameIsAlphabetic()
    {
        //prueba1
        // Prueba que el nombre de la bebida es alfabético.
        assertTrue(BeverageInputValidator.validateInput("Tea,4,6,8"));
    }

    @Test
    public void testNameLengthUnder2Chars()
    {
        //prueba2
        // Prueba que el nombre de la bebida tiene menos de 2 caracteres.
        assertFalse(BeverageInputValidator.validateInput("T,1,2,3"));
    }

    @Test
    public void testNameLengthWithinRange()
    {
        //prueba3
        // Prueba que la longitud del nombre de la bebida está dentro del rango especificado.
        assertTrue(BeverageInputValidator.validateInput("Latte,1,2,3,4,5"));
    }

    @Test
    public void testSizeInRange()
    {
        //prueba4
        // Prueba que el tamaño de la bebida está dentro del rango especificado.
        assertTrue(BeverageInputValidator.validateInput("Espresso,1,24,48"));
    }

    @Test
    public void testSizeIsInteger()
    {
        //prueba5
        // Prueba que el tamaño de la bebida es un número entero.
        assertFalse(BeverageInputValidator.validateInput("Coffee,2,2.5,3"));
    }

    @Test
    public void testSizesInAscendingOrder()
    {
        //prueba6
        // Prueba que los tamaños de la bebida se ingresan en orden ascendente.
        assertFalse(BeverageInputValidator.validateInput("Tea,3,2,1"));
    }

    @Test
    public void testOneToFiveSizes()
    {
        //prueba7
        // Prueba que se ingresa un mínimo de 1 y un máximo de 5 tamaños de bebida.
        assertTrue(BeverageInputValidator.validateInput("Tea,5"));
        assertTrue(BeverageInputValidator.validateInput("Tea,1,2,3,4,5"));
        assertFalse(BeverageInputValidator.validateInput("Tea,1,2,3,4,5,6"));
    }
    @Test
    public void testValidInput()
    {
        //prueba8
        // Prueba una entrada válida de nombre y tamaños de bebida.
        assertTrue(BeverageInputValidator.validateInput("Coffe,7,10,12"));
    }

    @Test
    public void testInvalidInputEmptyString()
    {
        //prueba9
        // Prueba una entrada inválida con una cadena vacía.
        assertFalse(BeverageInputValidator.validateInput(""));
    }

    @Test
    public void testInvalidInputNull()
    {
        //prueba10
        // Prueba una entrada inválida con un valor nulo.
        assertFalse(BeverageInputValidator.validateInput(null));
    }

    @Test
    public void testNameContainsSpecialCharacters()
    {
        //prueba11
        // Prueba que el nombre de la bebida no contiene caracteres especiales.
        assertFalse(BeverageInputValidator.validateInput("Coffe!Latte,7,1,2"));
    }

    @Test
    public void testNameExactlyFifteenCharsLong()
    {
        //prueba12
        // Prueba que el nombre de la bebida tiene exactamente 15 caracteres de longitud.
        assertFalse(BeverageInputValidator.validateInput("VanillaCaramelcoffe,8,15,21"));
    }

    @Test
    public void testDuplicateSizes()
    {
        //prueba13
        // Prueba que no hay tamaños de bebida duplicados.
        assertFalse(BeverageInputValidator.validateInput("Mocha,8,8,12"));
    }

    @Test
    public void testMaxSizeExceeded()
    {
        //prueba14
        // Prueba que el tamaño máximo de bebida no se excede.
        assertFalse(BeverageInputValidator.validateInput("Tea,6,24,49"));
    }

    @Test
    public void testNegativeSize()
    {
        //prueba15
        // Prueba que no hay tamaños de bebida negativos.
        assertFalse(BeverageInputValidator.validateInput("Tea,4,-10,22"));
    }

    @Test
    public void testInvalidSizeNonNumeric()
    {
        //prueba16
        // Prueba que todos los tamaños de bebida son números válidos.
        assertFalse(BeverageInputValidator.validateInput("Cofee,5,11a,21"));
    }

    @Test
    public void testInputWithLeadingWhitespace()
    {
        //prueba17
        // Prueba una entrada con espacios en blanco al principio del nombre de la bebida.
        assertTrue(BeverageInputValidator.validateInput(" Black Tea,5,11,21"));
    }
    @Test
    public void testInputWithWhitespace()
    {
        //prueba18
        // Prueba una entrada con espacios en blanco alrededor de los valores de tamaño.
        assertTrue(BeverageInputValidator.validateInput(" Black Tea , 2 , 7, 9 "));
    }
    @Test
    public void testNoRepeatedSizes()
    {
        //prueba19
        // Prueba que no hay tamaños de bebida repetidos.
        assertFalse(BeverageInputValidator.validateInput("Tea,5,5,12,24"));
    }

    @Test
    public void testReceiveList()
    {
        //prueba20
        // Prueba una entrada con una lista de tamaños de bebida.
        assertTrue(BeverageInputValidator.validateInput("Coffee,12,24,36"));
    }

    @Test
    public void testNonEmptyList()
    {
        //prueba21
        // Prueba una entrada con una lista no vacía de tamaños de bebida.
        assertTrue(BeverageInputValidator.validateInput("tea,6"));
    }

    @Test
    public void testMultipleBeverageSizes()
    {
        //prueba22
        // Prueba una entrada con múltiples tamaños de bebida.
        assertTrue(BeverageInputValidator.validateInput("Iced Tea,6,12"));
    }

    @Test
    public void testNameWithNumbers()
    {
        //prueba23
        // Prueba que el nombre de la bebida no contiene números.
        assertFalse(BeverageInputValidator.validateInput("Cafe5,1,2,3"));
    }

    @Test
    public void testNameWithSpecialCharacters()
    {
        //prueba24
        // Prueba que el nombre de la bebida no contiene caracteres especiales, excepto la tilde.
        assertFalse(BeverageInputValidator.validateInput("Café,1,2,3"));
    }

    @Test
    public void testEmptySize()
    {
        //prueba25
        // Prueba que no se permite un tamaño de bebida vacío.
        assertFalse(BeverageInputValidator.validateInput("Latte,,12,24"));
    }

    @Test
    public void testMaxSize()
    {
        //prueba26
        // Prueba que se permite el tamaño máximo de bebida.
        assertTrue(BeverageInputValidator.validateInput("Tea,6,12,24,48"));
    }

    @Test
    public void testZeroSize()
    {
        //prueba27
        // Prueba que no se permite un tamaño de bebida de cero.
        assertFalse(BeverageInputValidator.validateInput("Tea,0,12,24"));
    }

    @Test
    public void testNegativeName()
    {
        //prueba29
        // Prueba que no se permite un nombre de bebida negativo.
        assertFalse(BeverageInputValidator.validateInput("-Tea,6,12,24"));
    }

    @Test
    public void testNoComma()
    {
        //prueba30
        // Prueba que cada tamaño de bebida está separado por comas.
        assertFalse(BeverageInputValidator.validateInput("Mocha 1 2 3"));
    }

    @Test
    public void testMaxSizes()
    {
        //prueba31
        // Prueba que no se permite más de cinco tamaños de bebida.
        assertFalse(BeverageInputValidator.validateInput("Latte,1,2,3,4,5,6"));
    }

    @Test
    public void testOnlyName()
    {
        //prueba32
        // Prueba que se debe proporcionar al menos un tamaño de bebida.
        assertFalse(BeverageInputValidator.validateInput("Espresso"));
    }
}
