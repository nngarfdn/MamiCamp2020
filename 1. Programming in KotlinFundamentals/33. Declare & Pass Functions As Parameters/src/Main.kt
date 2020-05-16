import java.security.cert.CertPathValidator

fun validatePassword(password: String) = password.length >= 10
fun main() {

    val email : String? = "nanang@gmail.com"
    val password : String? = "sdjgjdsfhbsdf"

    fun validdateString(input: String?, inputType: String) =
        if (input==null || input.isEmpty()) {
            false
        } else if (inputType == "Password") {
            input.length >= 10
        } else if (inputType == "Email") {
            input.contains("@")
        } else {
            println("Cannot Verify this input")
            false
        }

    fun validateString(input: String? , validator : (String) -> Boolean) =
        if (input== null || input.isEmpty()){
            false
        } else{
            validator(input)
        }




    validdateString("Hello Word", "Welcome Message")

    val isValidEmail = validdateString(email,"Email")
    println(isValidEmail)

    val isValidPassword = validateString(password, ::validatePassword)
    println(isValidPassword)

    val passwordVAlidator = ::validatePassword
    println(passwordVAlidator)

    val validator: (String?) -> Boolean = {input ->
        input != null && validatePassword(input)
    }
    println(validator)

}