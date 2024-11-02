// General JavaScript functions for interactivity and API calls

function submitSymptoms() {
    const symptoms = document.getElementById('symptoms').value;
    fetch(`/api/symptoms?input=${encodeURIComponent(symptoms)}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('diagnosisResult').innerHTML = `
                <h3>Probable Diagnosis:</h3>
                <p>${data.diagnosis}</p>
                <h3>Suggested Medication:</h3>
                <p>${data.medication}</p>
            `;
        })
        .catch(error => console.error('Error:', error));
}

function searchDoctors() {
    const specialty = document.getElementById('specialty').value;
    fetch(`/api/doctors?specialty=${encodeURIComponent(specialty)}`)
        .then(response => response.json())
        .then(data => {
            let doctorsHTML = "<h3>Available Doctors:</h3>";
            data.forEach(doctor => {
                doctorsHTML += `<p><strong>${doctor.name}</strong> - ${doctor.specialty}<br>${doctor.contact}</p>`;
            });
            document.getElementById('doctorList').innerHTML = doctorsHTML;
        })
        .catch(error => console.error('Error:', error));
}

function setReminder() {
    const task = document.getElementById('task').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const notes = document.getElementById('notes').value;

    fetch('/api/reminders', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ task, date, time, notes })
    })
    .then(response => response.json())
    .then(data => {
        displayReminders(data.reminders);
        alert("Reminder set successfully!");
    })
    .catch(error => console.error('Error:', error));
}

function displayReminders(reminders) {
    const reminderList = document.getElementById('reminderList');
    reminderList.innerHTML = '<h3>Your Reminders</h3>';
    reminders.forEach(reminder => {
        reminderList.innerHTML += `
            <div class="reminder-item">
                <p><strong>Task:</strong> ${reminder.task}</p>
                <p><strong>Date:</strong> ${reminder.date}</p>
                <p><strong>Time:</strong> ${reminder.time}</p>
                <p><strong>Notes:</strong> ${reminder.notes ? reminder.notes : 'No notes'}</p>
                <hr>
            </div>
        `;
    });
}

document.addEventListener('DOMContentLoaded', () => {
    fetch('/api/reminders')
        .then(response => response.json())
        .then(data => {
            displayReminders(data.reminders);
        })
        .catch(error => console.error('Error:', error));
});
