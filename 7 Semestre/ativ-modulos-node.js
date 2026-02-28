function getAverage(array) {
    if (!Array.isArray(array)) {
        return null;
    }
    let sum = 0;
    let validSize = 0;
    for (let i of array) {
        let value = Number(i)
        if (Number.isNaN(value)) {
            continue;
        }
        sum += value;
        validSize++;
    }
    if (validSize === 0) {
        return null;
    }
    return sum / validSize;
}

function getSmallest(array) {
    if (!Array.isArray(array)) {
        return null;
    }

    let smallest = null;

    for (let i of array) {
        let value = Number(i);
        if (Number.isNaN(value)) {
            continue;
        } else {
            if (smallest === null || value < smallest) {
                smallest = value;
            }
        }
    }
    if (smallest !== null) {
        return smallest;
    }
    return null;
}

function getBiggest(array) {
    if (!Array.isArray(array)) {
        return null;
    }

    let biggest = null;

    for (let i of array) {
        let value = Number(i);
        if (Number.isNaN(value)) {
            continue;
        } else {
            if (biggest === null || value > biggest) {
                biggest = value;
            }
        }
    }
    if (biggest !== null) {
        return biggest;
    }
    return null;
}

module.exports = { getAverage, getSmallest, getBiggest };