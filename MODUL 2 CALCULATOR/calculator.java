let display = document.getElementById('display');
let keys = document.querySelectorAll('.keys button');

let calculator = {
    displayValue: '',
    firstOperand: '',
    operator: '',
    secondOperand: '',
    result: '',

    clear: function() {
        this.displayValue = '';
        this.firstOperand = '';
        this.operator = '';
        this.secondOperand = '';
        this.result = '';
        display.value = '';
    },

    handleNumber: function(number) {
        this.displayValue += number;
        display.value = this.displayValue;
    },

    handleOperator: function(operator) {
        this.firstOperand = this.displayValue;
        this.operator = operator;
        this.displayValue = '';
    },

    handleEquals: function() {
        this.secondOperand = this.displayValue;
        switch (this.operator) {
            case '+':
                this.result = parseFloat(this.firstOperand) + parseFloat(this.secondOperand);
                break;
            case '-':
                this.result = parseFloat(this.firstOperand) - parseFloat(this.secondOperand);
                break;
            case '*':
                this.result = parseFloat(this.firstOperand) * parseFloat(this.secondOperand);
                break;
            case '/':
                this.result = parseFloat(this.firstOperand) / parseFloat(this.secondOperand);
                break;
            case '^':
                this.result = Math.pow(parseFloat(this.firstOperand), parseFloat(this.secondOperand));
                break;
            case '%':
                this.result = parseFloat(this.firstOperand) % parseFloat(this.secondOperand);
                break;
        }
        display.value = this.result;
        this.displayValue = '';
        this.firstOperand = '';
        this.operator = '';
        this.secondOperand = '';
    }
};

keys.forEach(function(key) {
    key.addEventListener('click', function() {
        let keyValue = key.id;
        switch (keyValue) {
            case 'clear':
                calculator.clear();
                break;
            case 'divide':
                calculator.handleOperator('/');
                break;
            case 'multiply':
                calculator.handleOperator('*');
                break;
            case 'subtract':
                calculator.handleOperator('-');
                break;
            case 'add':
                calculator.handleOperator('+');
                break;
            case 'power':
                calculator.handleOperator('^');
                break;
            case 'modulus':
                calculator.handleOperator('%');
                break;
            case 'equals':
                calculator.handleEquals();
                break;
            default:
                calculator.handleNumber(keyValue);
        }
    });
});