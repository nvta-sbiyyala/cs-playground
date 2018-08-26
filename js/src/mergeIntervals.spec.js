/* describe */

function compute(compareWith, toCompare) {
    if (compareWith[1] >= toCompare[0]) {
        if (compareWith[1] >= toCompare[1]) {
            return [compareWith];
        } else {
            return [[compareWith[0], toCompare[1]]];
        }
    } else {
        return [compareWith, toCompare];
    }
}

const scenarios = [
    {
        description: 'first case',
        input: [[2, 5], [4, 8], [10, 12]],
        output: [[2, 8], [10, 12]]
    },
    {
        description: 'second case',
        input: [[1, 3], [2, 4], [5, 7], [6, 8]],
        output: [[1, 4], [5, 8]]
    },
    {
        description: 'third case',
        input: [[6, 8], [1, 9], [2, 4], [4, 7]],
        output: [[1, 9]]
    },
    {
        description: 'fourth case',
        input: [[1,3], [2,6], [8,10], [15,18]],
        output: [[1,6], [8,10], [15,18]]
    },
    {
        description: 'fifth case',
        input: [[1,3], [3,6], [5,10], [15,18]],
        output: [[1,10], [15,18]]
    }
];

describe('Wrapper', () => {
    scenarios.forEach(({description, input, output}) => {
        describe(`Given ${description}`, () => {
            it('Then result', () => {
                input.sort((e1, e2) => e1[0] - e2[0]);
                let result = [input[0]];
                for (let i = 1; i < input.length; i++) {
                    const computed = compute(result.pop(), input[i]);
                    result = result.concat(computed);
                }
                expect(result).toEqual(output);
            });
        });
    });
});
