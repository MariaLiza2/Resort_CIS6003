<html>
<head>
    <title>Add Reservation</title>
</head>
<body>

<h2>New Reservation</h2>

<form action="addReservation" method="post">

    Guest Name:
    <input type="text" name="guestName" required><br><br>

    Address:
    <textarea name="address" required></textarea><br><br>

    Contact Number:
    <input type="text" name="contact" required><br><br>

    Room Type:
    <select name="roomType">
        <option>Standard</option>
        <option>Deluxe</option>
        <option>Suite</option>
    </select><br><br>

    Check-in Date:
    <input type="date" name="checkIn" required><br><br>

    Check-out Date:
    <input type="date" name="checkOut" required><br><br>

    <input type="submit" value="Save Reservation">

</form>

</body>
</html>
