<?php
    namespace App;
    class Calculator {
        public function sum($a, $b) {
            return $a + $b;
        }

        public function subtract($a, $b) {
            return $a - $b;
        }

        public function multiply($a, $b) {
            return $a * $b;
        }

        public function divide($a, $b) {
            if ($b === 0) {
                throw new \DivisionByZeroError("Division by zero attempted!");
            }
            return $a / $b;
        }

        public function isEven($a) {
            return $a%2==0;
        }

        public function arraySum($a) {
            $sum = 0;
            for ($i=0; $i < sizeof($a); $i++) { 
                $sum += $a[$i];
            }
            return $sum;
        }
    }
?>