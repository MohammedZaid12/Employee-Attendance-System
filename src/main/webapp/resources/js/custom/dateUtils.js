const monthNames = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
    'July',
    'August',
    'September',
    'October',
    'November',
    'December'
];

const SEPARATOR = '-';

/**
 * return Map containing key MMMM-YYYY and value as String dates in that month and year
 * @param {string []} datesArray
 * @returns {Map<String , String []>}
 */
function getMapOFMonthsAndDates(datesArray) {
    let monthDatesMap = new Map();
    monthNames.forEach(monthName => {
        let datesList = datesArray.filter(value => monthNames[moment(value).month()] === monthName);
        if(datesList.length > 0){
            let dateYearSet = new Set(datesList.map(val => new Date(val).getFullYear()));
            dateYearSet.forEach(year => {
                let finalDatesList = datesList.filter(  date =>  moment(date).year() === year );
                monthDatesMap.set(monthName + SEPARATOR + year , finalDatesList);
            });
        }
    })
    return monthDatesMap;
}

/**
 * @param {string}  month number, 0 based
 * @param {number}  year, not zero based, required to account for leap years
 * @return {string []} List with String dates of the month
 */
function getDatesInMonth(month, year) {
    let date = new Date(year, moment().month(month).month(), 1);
    let datesListOfMonth = [];
    while (date.getMonth() === moment().month(month).month()) {
        datesListOfMonth.push(moment(date).format('YYYY-MM-DD'));
        date.setDate(date.getDate() + 1);
    }
    return datesListOfMonth;
}


/**
 * @param {string}  month number, 0 based
 * @param {number}  year, not zero based, required to account for leap years
 * @return {number} days in month
 */
function getDaysInMonth(month, year) {
    return  getDatesInMonth(month, year).length;
}

/**
 * @param {string} month name
 * @param {number} year, not zero based, required to account for leap year
 * @return {string} start date of that month and year
 */
function getStartDateOfMonthAndYear(month, year) {
    let monthDate = getDatesInMonth(month, year);
    if(monthDate.length > 0)
        return monthDate[0];
    else
        return '';
}

/**
 * @param {string} month name
 * @param {number} year, not zero based, required to account for leap year
 * @return {string} end date of that month and year
 */
function getEndDateOfMonthAndYear(month, year) {
    let monthDate = getDatesInMonth(month, year);
    if(monthDate.length > 0)
        return monthDate[monthDate.length - 1];
    else
        return '';
}

/**
 * @param {Date} date current date
 * @return {string} current month name
 */
function getCurrentMonthFromDate(date) {
     return monthNames[date.getMonth()];
}