<script>
  import A from "../components/A.svelte";
  import AH from "../components/AH.svelte";
  import Theme from "../components/Theme.svelte";

  let navHidden = true

  function showNav() {
    if (navHidden) {
      document.getElementById('nav-res').classList.replace('hidden', 'absolute')
    } else {
      document.getElementById('nav-res').classList.replace('absolute', 'hidden')
    }
    navHidden = !navHidden
  }
</script>

<div class="header">
  <h1 class="logo">MovieDB</h1>

  <nav class="desktop-nav">
    <A props={{name: "Home", link:"/"}} />
    <A props={{name: "Search", link:"/search"}} />
    <div class="theme-switcher">
      <Theme />
    </div>
  </nav>
  
  <nav id="nav-res" class="mobile-nav">
    <button on:click={showNav}>
      <AH props={{name: "Home", link:"/"}} />
    </button>
    <button on:click={showNav}>
      <AH props={{name: "Search", link:"/search"}} />
    </button>
    <button on:click={showNav} class="theme-switcher">
      <Theme />
    </button>
  </nav>
  
</div>

<style>
  .header {
    background-color: rgb(229, 231, 235); /* Set your desired background color */
    height: 12vh;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 1rem;
  }

  .logo {
    font-size: 2rem;
  }

  .desktop-nav{
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .theme-switcher {
    display: inline-block;
    cursor: pointer;
    padding: 0.5rem;
    border-radius: 0.25rem;
    &:hover {
      background-color: #ddd; /* Set your desired hover background color */
    }
  }

  .mobile-nav {
    display: none;
  }

  /* Media query to show mobile nav */
  @media screen and (max-width: 600px) {
    .mobile-nav {
      display: flex;
      flex-direction: column;
      position: absolute;
      top: 12vh;
      left: 0;
      width: 100%;
      background-color: #ccc; /* Set your desired background color */
      padding: 1rem;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      z-index: 1;
    }
    .mobile-nav button {
      margin-bottom: 1rem;
      text-align: left;
    }
  }
</style>