<?php
// Atividade Prática 01 - Felipe Casali 802.483

function power($base, $exponent) {
    $res = 1;
    for ($i = 0; $i < $exponent; $i++) {
        $res *= $base;
    }
    return $res;
}

echo power(3, 3);

echo "\n";
// ---------------------------------------------------------------

function isPair($number) {
    return $number % 2 == 0;
}

echo isPair(7) ? 1 : 0;

echo "\n";
// ---------------------------------------------------------------

function verifyNumber($number) {
    if ($number == 0) {
        return 0;
    } else if ($number < 0) {
        return -1;
    } else {
        return 1;
    }
}

echo verifyNumber(-3);

echo "\n";
// ---------------------------------------------------------------

function findDivisors($number) {
    $divisors = [];
    for ($i = 1; $i < $number; $i++) {
        if ($number % $i == 0) {
            $divisors[] = $i;
        }
    }
    return $divisors;
}

function isPerfect($number) {
    return $number == array_sum(findDivisors($number));
}

echo isPerfect(6) ? 1 : 0;

echo "\n";
// ---------------------------------------------------------------

function calcIdealWeight($height, $sex) {
    if (strtolower($sex) == "h") {
        return ($height*72.7) - 58;
    } else if (strtolower($sex) == "m") {
        return ($height*62.1) - 44.7;
    } else {
        return 0;
    }
}

echo calcIdealWeight(1.80, "h");

echo "\n";
// ---------------------------------------------------------------

function calcFactorial($number) {
    $factorial = 1;
    for ($i = 1; $i <= $number; $i++) {
        $factorial *= $i;
    }
    return $factorial;
}

echo calcFactorial(5);
?>