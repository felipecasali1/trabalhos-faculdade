<?php

namespace Tests;
use App\Calculator;
use PHPUnit\Framework\TestCase;

    class CalculatorTest extends TestCase {
        private $calculator;

        protected function setUp(): void {
            $this->calculator = new Calculator();
        }

        public function testSum(): void {
            $result = $this->calculator->sum(1, 1);
            $this->assertEquals(2, $result);
        }
        
        public function testSubtract(): void {
            $result = $this->calculator->subtract(1, 1);
            $this->assertEquals(0, $result);
        }

        public function testMultiply(): void {
            $result = $this->calculator->multiply(1, 1);
            $this->assertEquals(1, $result);
            
            $result = $this->calculator->multiply(1, 0);
            $this->assertEquals(0, $result);
        }

        public function testDivide(): void {
            $result = $this->calculator->divide(1, 1);
            $this->assertEquals(1, $result);
        }

        public function testDivideByZero(): void {
            $this->expectException(\DivisionByZeroError::class);
            $result = $this->calculator->divide(1, 0);
        }

        public function testIsEven(): void {
            $this->assertTrue($this->calculator->isEven(2));
            $this->assertFalse($this->calculator->isEven(1));
        }

        public function testArraySum(): void {
            $array = [1,2,3,4,5];
            $result = $this->calculator->arraySum($array);
            $this->assertEquals(15, $result);
        }
    }
?>