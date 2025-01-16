/**
 * @param {number[][]} grid
 * @return {number}
 */
var equalPairs = function(grid) {
    let rows = {};
    let count = 0;

    for (let i = 0; i < grid.length; i++) {
        let rowStr = JSON.stringify(grid[i]);
        rows[rowStr] = (rows[rowStr] || 0) + 1;
    }

    for (let j = 0; j < grid.length; j++) {
        let column = [];
        for (let i = 0; i < grid.length; i++) {
            column.push(grid[i][j]);
        }

        let columnStr = JSON.stringify(column);
        if (rows[columnStr]) {
            count += rows[columnStr];
        }
    }

    return count;
};
