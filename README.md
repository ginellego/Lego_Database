# Lego Database 
This program is for querying the LEGO database in a command line interface. The database is loaded to a MYSQL server. 

This program was initially an assignment for the Databases course (COMP 3380) at the University of Manitoba. Modifications have been made to update the program, changing the required design for the assignment and making it my own. 

## Starting the program
To run the program, open the main directory and enter "make" in the command line. Then enter "run" in the command line. 

## Queries
Enter one of the following commands to query the database. Note: Don't include the {} in the query. They are placeholders for the input. 

h - Get help
cp, {number or "all"} - Most common parts in {number} sets. 
year, {year}, {number} - Sets by {year} with less than {number} pieces. 
pt, {number or "all"} - Top {number} popular themes and set count. 
inspired, {number}, {part} - Top {number} sets with parts inspired by {part}. 
ctpieces, {number}, {color} - Top {number} sets with the most {color} parts and their theme. 
excl, {number}, {theme}, {mini figure} - Top {number} sets without a {mini figure} in a {theme}. 
sc, {set} - Number of parts in each category of parts in {set}. 
inv, {number} - Top {number} set with the most inventories. 
cc, {number}, {category} - {Number} part names in a {category}. 
mini, {number}, {mini} - Top {number} sets that include this {mini}. 
mc, {number}, {color} - Top {number} sets and image urls with at least a quarter of parts that are {color}. 
noset, {number} - {Number} parts that are not included in a set. 
at, {number} - Top {number} themes that have the greatest average in pieces across all sets. 
setwithout, {number}, {part} - Top {number} of sets without {part}. 
sm - Sets with parts of all the same material. 
numColors, {set} - Number of colours in a {set}. 
mostColors - Set with the most variety in colors. 
wm, {number}, {material} - {Number} of sets without parts of a certain {material}.
partsYear, {year} - Average number of parts in sets created in {year}. 
populate - Add all tables and their data to the database. 
q - Exit the program. 

