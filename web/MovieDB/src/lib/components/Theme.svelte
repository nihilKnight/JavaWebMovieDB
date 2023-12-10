<script>
  let dark = false

  function changeTheme() {
    document.documentElement.classList.toggle('dark')
    dark = !dark
  }
</script>

<button 
  on:click={changeTheme}
  class="custom-change">
  {#if dark}
    &#9728;
  {:else}
    &#127770;
  {/if}
</button>

<style>
  .custom-change {
    width: 100%; /* 对应 w-full */
    padding: 0.5rem; /* 对应 px-2 */
    padding-top: 0.5rem; /* 对应 py-2 */
    padding-bottom: 0.5rem; /* 对应 py-2 */
  }
</style>