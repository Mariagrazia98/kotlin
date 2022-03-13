class BankAccount {
    /* private var balanceSupport:Long=0
     var closeAccount:Boolean=false
     val balance:Long
         get(){
             if(closeAccount){
                 throw IllegalStateException()

             }
             else{
                 return balanceSupport;
             }
         }

     fun adjustBalance(amount: Long){
         if(closeAccount){
             throw IllegalStateException()
         }
         else{
             synchronized(this){
                 balanceSupport= balanceSupport+amount
             }
         }
     }

     fun close() {
         closeAccount=true;
     }*/

    /*Alternative solution*/
    private var open = true;
    var balance: Long = 0
        get() {
            check(open); return field
        } //Backing field is generated only if a property uses the default implementation of getter/setter.
        private set

    fun adjustBalance(amount: Long) {
        check(open) //check throws an IllegalStateException if the value is false.
        synchronized(this) {
            this.balance += amount;
        }
    }

    fun close() {
        open = false
    }
}
