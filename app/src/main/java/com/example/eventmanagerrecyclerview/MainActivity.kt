package com.example.eventmanagerrecyclerview

import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventmanagerrecyclerview.CompletedEvents.CompletedEventAdapter
import com.example.eventmanagerrecyclerview.CompletedEvents.CompletedEvents
import com.example.eventmanagerrecyclerview.Staff.Staff
import com.example.eventmanagerrecyclerview.Staff.StaffAdapter
import com.example.eventmanagerrecyclerview.UpcomingEvents.UpcomingEventAdapter
import com.example.eventmanagerrecyclerview.UpcomingEvents.UpcomingEvents
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private val upcomingEventsList = ArrayList<UpcomingEvents>()
    private val completedEventsList = ArrayList<CompletedEvents>()
    private val staffList = ArrayList<Staff>()
    private lateinit var adapterUpcoming: UpcomingEventAdapter
    private lateinit var adapterCompleted: CompletedEventAdapter
    private lateinit var adapterStaff: StaffAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUpcomingEvents = findViewById<Button>(R.id.btn_upcoming)
        val btnCompletedEvents = findViewById<Button>(R.id.btn_completed)
        val btnAvailableStaff = findViewById<Button>(R.id.btn_staff)

        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        adapterStaff = StaffAdapter()
        adapterUpcoming = UpcomingEventAdapter()
        adapterCompleted = CompletedEventAdapter()
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

        addUpcomingEventItems()
        addCompletedEventItems()
        addStaffItems()

        btnUpcomingEvents.setOnClickListener() {
            btnUpcomingEvents.isEnabled = false;
            btnCompletedEvents.isEnabled = true;
            btnAvailableStaff.isEnabled = true;

            recyclerView.adapter = adapterUpcoming
            upcomingEventsList.sortBy { it.eventTitle }
            adapterUpcoming.items = upcomingEventsList
            adapterUpcoming.notifyDataSetChanged()
        }

        btnCompletedEvents.setOnClickListener() {
            btnUpcomingEvents.isEnabled = true;
            btnCompletedEvents.isEnabled = false;
            btnAvailableStaff.isEnabled = true;

            recyclerView.adapter = adapterCompleted
            completedEventsList.sortByDescending { it.completeDate }
            adapterCompleted.items = completedEventsList
            adapterCompleted.notifyDataSetChanged()
        }

        btnAvailableStaff.setOnClickListener() {
            btnUpcomingEvents.isEnabled = true;
            btnCompletedEvents.isEnabled = true;
            btnAvailableStaff.isEnabled = false;

            recyclerView.adapter = adapterStaff
            staffList.sortBy { it.name }
            adapterStaff.items = staffList
            adapterStaff.notifyDataSetChanged()
        }
    }

    private fun addUpcomingEventItems() {
        upcomingEventsList.add(UpcomingEvents("Covid Vaccination Drive", "April 1st", "Populations across the world spent most of 2020 in anticipation of a vaccine for the deadly covid-19. Thankfully, by the end of the year, things were looking up. It has been projected that vaccination drives will begin all over India with first priority given to healthcare workers. These vaccination drives will begin in January itself. So far, two different covid vaccines have been approved for emergency use in India: Astrazeneca’s Covishield and Bharat Biotech’s Covaxin.", "--"))
        upcomingEventsList.add(UpcomingEvents("Launch of the James Webb Telescope", "October 31st, 14:00 - 18:00", "NASA has pioneered much of the innovation in aeronautics, and in one of the most exciting upcoming events in 2021 for space enthusiasts, NASA will be replacing its famous Hubble Space Telescope with the James Webb Space Telescope (or JWST). Named after James E Webb, the administrator of NASA who oversaw the Apollo mission, the JWST will be launched on 31st October 2021. The new space telescope is expected to have much clearer imaging than its predecessor.", "NASA"))
        upcomingEventsList.add(UpcomingEvents("Tokyo Summer Olympics", "July 23rd - August 8th", "One of the most important events to get delayed due to the pandemic was the Tokyo 2020 summer Olympics. Because of the importance of the Olympic games in the sports world, the 2020 Tokyo Olympics is one of the most awaited upcoming events in 2021.", "--"))
        upcomingEventsList.add(UpcomingEvents("Dubai World Expo", "October 1st 2021 - March 31st 2022", "World Expos are events that are not only globally significant because of their magnificence, they are also a means of cultural exchange.", "--"))
        upcomingEventsList.add(UpcomingEvents("Launch of Chandrayan III ", "November - December 2021", "When Chandrayaan II was launched in 2019, the goal was to have a robotic rover over the surface of the moon to make observations. Chandrayaan II deviated from its course, however, and could not make a soft landing. Chandrayan III is expected to be launched by late 2021 to finish the goals set for Chandrayan II. The new Chandrayan III will have a different design than its predecessor.", "ISRO"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addCompletedEventItems() {
        completedEventsList.add(CompletedEvents("Completed Event1", LocalDate.parse("2018-03-09"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "))
        completedEventsList.add(CompletedEvents("Completed Event2", LocalDate.parse("2020-12-11"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "))
        completedEventsList.add(CompletedEvents("Completed Event3", LocalDate.parse("2020-05-17"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "))
        completedEventsList.add(CompletedEvents("Completed Event4", LocalDate.parse("2019-08-05"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "))
        completedEventsList.add(CompletedEvents("Completed Event5", LocalDate.parse("2012-10-23"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "))
    }

    private fun addStaffItems() {
        staffList.add(Staff("Darin Williams", 19, "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery."))
        staffList.add(Staff("Evelyn Pierre", 18, "The Noxian occupation of Ionia produced many heroes, none more unlikely than young Irelia of Navori. Trained in the ancient dances of her province, she adapted her art for war, using the graceful and carefully practised movements to levitate a host of deadly blades."))
        staffList.add(Staff("Barbara Dean", 32, "While many other yordles channel their energy into discovery, invention, or just plain mischief-making, Tristana was always inspired by the adventures of great warriors."))
        staffList.add(Staff("Ricky Daniels", 20, "Fueled by unbridled fury and rage, Tryndamere once carved his way through the Freljord, openly challenging the greatest warriors of the north to prepare himself for even darker days ahead."))
        staffList.add(Staff("Ken Rhodes", 19, "Utterly ruthless and without mercy, Zed is the leader of the Order of Shadow, an organization he created with the intent of militarizing Ionia's magical and martial traditions to drive out Noxian invaders."))
    }
}